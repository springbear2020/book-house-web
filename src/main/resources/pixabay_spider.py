from datetime import date
import requests
import json
import pymysql

# 输入并设置请求的图片参数
condition = input("condition:")
page = input('page(20 pictures per page):')
req_params = {
    'key': '26183514-10870193e7b68335958cb6abb',
    'q': condition,
    'lang': 'en',
    'orientation': 'horizontal',
    'page': -1,
}

# 设置数据库信息
db = pymysql.connect(host='124.221.120.56', user="admin", passwd="5n0vtv0m07pw", port=3306, db='book_house', charset='utf8')
cursor = db.cursor()

resCount = 0
saveCount = 0
for i in range(0, int(page)):
    # 请求 Pixabay 第 page 页的图片数据并解析为 json 对象
    req_params['page'] = i + 1
    request = requests.get('https://pixabay.com/api/', params=req_params, headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36'})
    decode_json = json.loads(request.text)

    # 依次解析当前页的每张图片信息并保存到数据库
    for picture in decode_json['hits']:
        resCount += 1
        print(str(resCount) + ": " + picture['largeImageURL'])
        # choice = input("Save this picture or not[y/n]:")
        # if(choice != 'y'):
        #     continue
        saveCount += 1
        print("The " + str(saveCount) + " pictures is saving to the database······")
        sql = """INSERT INTO t_pixabay(`type`,`tags`,`views`,`downloads`,`collections`,`likes`,`comments`,`add_time`,`page_url`,`image_width`,`image_height`,`image_size`,`large_image_url`,`preview_width`,`preview_height`,`preview_url`,`web_format_width`,`web_format_height`,`web_format_url`,`user_id`,`user`,`user_image_url`) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);"""
        cursor.execute(sql, (picture['type'], picture['tags'], picture['views'],picture['downloads'], picture['collections'], picture['likes'], picture['comments'], date.today(), picture['pageURL'], picture['imageWidth'], picture['imageHeight'], picture['imageSize'], picture['largeImageURL'], picture['previewWidth'], picture['previewHeight'], picture['previewURL'], picture['webformatWidth'], picture['webformatHeight'], picture['webformatURL'], picture['user_id'], picture['user'], picture['userImageURL']))
        db.commit()
cursor.close()
db.close()
