$(function () {
    let $img = $('.change-hd>img');
    let $imgTrue = $('.change-hd');
    // 将上传的头像显示到页面
    $('.chooseImg').on('change', function () {
        // 获取上传的图片的文件路径
        let src = window.URL.createObjectURL(this.files[0]);
        // 修改头像的图片
        $img.attr('src', src);
        $(".updatePortraitBtn").css('display', 'block' );
    })
    // 头像的鼠标移入事件
    $imgTrue.mouseover(function () {
        $imgDiv.css('display', 'block');
    });
    $imgTrue.mouseleave(function () {
        $imgDiv.css('display', 'none');
    });

    // 神奇的 js 允许你先调用再定义变量
    let $imgDiv = $('.change-hd>div');

    let eyeClosed = false;
    $(".pas-eye").click(function () {
        if (eyeClosed) {
            // 如果闭眼 则睁眼，由可见变为不可见
            this.src = "static/img/eye.png"
            $(".data-pwd").prop('type', 'password');
            eyeClosed = false;
        } else {
            // 如果睁眼 则闭眼，由不可见变为可见
            this.src = "static/img/eye_closed.png"
            $(".data-pwd").prop('type', 'text');
            eyeClosed = true;
        }
    })


    // let $btnSure = $('.change-sure');
    // let $btnCancel = $('.change-cancel');
    // 地区锁
    // let areaLock = false;
    // 点击修改资料
    // $('.per-change-check').click(function () {
    //     // 让所有输入框都可以被修改
    //     $('.per-data-text').attr('disabled', false);
    //     $('.per-data-sex').attr('disabled', false);
    //     // 关闭地区锁
    //     // areaLock = true;
    //     // 让两个按钮出现
    //     $('.change-btn-li').css('display', 'block');
    // })
    // // 取消按钮的点击事件
    // $btnCancel.click(function () {
    //     // 让所有输入框锁起来
    //     $('.per-data-text').attr('disabled', true);
    //     $('.per-data-sex').attr('disabled', true);
    //     // 打开地区锁
    //     // areaLock = false;
    //     // 让两个按钮消失
    //     $('.change-btn-li').css('display','none');
    // })
    // // 保存按钮的点击事件
    // $btnSure.click(function () {
    //     // 让两个按钮消失
    //     $('.change-btn-li').css('display','none');
    //     // 让所有输入框锁起来
    //     $('.per-data-text').attr('disabled', true);
    //     $('.per-data-sex').attr('disabled', true);
    //     // 打开地区锁
    //     // areaLock = false;
    // })

    // 地区输入框的点击事件
    $('.area-data').click(function () {
        // if(areaLock){
        // 让地区的下拉框显示出来
        $('.area-frame').css('display', 'block');
        // }
    })
    // 点击地区框以外的地方隐藏下拉框
    $(document).bind('click', function (e) {
        let elem = e.target;
        // 循环判断至根节点
        while (elem) {
            if (elem.className && elem.className === "area-whole") {
                return;
            }
            elem = elem.parentNode;
        }
        //让地区的下拉框消失
        $('.area-frame').css('display', 'none');
    })

    // 地区相关的参数

    let china = {};

    china['北京市'] = ['密云区', '延庆区', '朝阳区', '丰台区', '石景山区', '海淀区', '门头沟区', '房山区', '通州区', '顺义区', '昌平区', '大兴区', '怀柔区', '平谷区', '东城区', '西城区']

    china['上海市'] = ['黄浦区', '徐汇区', '长宁区', '静安区', '普陀区', '虹口区', '杨浦区', '浦东新区', '闵行区', '宝山区', '嘉定区', '金山区', '松江区', '青浦区', '奉贤区', '崇明区'];

    china['天津市'] = ['和平区', '河东区', '河西区', '南开区', '河北区', '红桥区', '滨海新区', '东丽区', '西青区', '津南区', '北辰区', '武清区', '宝坻区', '宁河区', '静海区', '蓟州区'];

    china['重庆市'] = ['万州区', '黔江区', '涪陵区', '渝中区', '大渡口区', '江北区', '沙坪坝区', '九龙坡区', '南岸区', '北碚区', '渝北区', '巴南区', '长寿区', '江津区', '合川区', '永川区', '南川区', '綦江区', '大足区', '铜梁区', '璧山区', '潼南区', '荣昌区', '开州区', '梁平区', '武隆区'];

    china['河北省'] = ['石家庄', '唐山市', '邯郸市', '秦皇市岛', '保市定', '张家市口', '承德市', '廊坊市', '沧州市', '衡水市', '邢台市'];

    china['山西省'] = ['太原市', '大同市', '阳泉市', '长治市', '晋城市', '朔州市', '晋中市', '运城市', '忻州市', '临汾市', '吕梁市'];

    china['辽宁省'] = ['沈阳市', '大连市', '鞍山市', '抚顺市', '本溪市', '丹东市', '锦州市', '营口市', '阜新市', '辽阳市', '盘锦市', '铁岭市', '朝阳市', '葫芦岛市'];

    china['吉林省'] = ['长春市', '吉林市', '四平市', '辽源市', '通化市', '白山市', '松原市', '白城市', '延边州', '长白山管委会'];

    china['黑龙江省'] = ['哈尔滨市', '齐齐哈尔市', '大庆市', '佳木斯市', '牡丹江市', '七台河市', '双鸭山市', '黑河市', '鸡西市', '伊春市', '绥化市', '鹤岗市', '加格达奇市'];

    china['江苏省'] = ['南京市', '苏州市', '无锡市', '常州市', '南通市', '扬州市', '镇江市', '泰州市', '盐城市', '连云港市', '宿迁市', '淮安市', '徐州市'];

    china['浙江省'] = ['杭州市', '宁波市', '温州市', '嘉兴市', '湖州市', '绍兴市', '金华市', '衢州市', '舟山市', '台州市', '丽水市'];

    china['安徽省'] = ['合肥市', '芜湖市', '蚌埠市', '淮南市', '马鞍山市', '淮北市', '铜陵市', '安庆市', '黄山市', '滁州市', '阜阳市', '宿州市', '巢湖市', '六安市', '亳州市', '池州市', '宣城市'];

    china['福建省'] = ['福州市', '厦门市', '莆田市', '三明市', '泉州市', '漳州市', '南平市', '龙岩市', '宁德市'];

    china['江西省'] = ['南昌市', '景德镇市', '萍乡市', '九江市', '新余市', '鹰潭市', '赣州市', '吉安市', '宜春市', '抚州市', '上饶市'];

    china['山东省'] = ['济南市', '青岛市', '淄博市', '枣庄市', '东营市', '烟台市', '潍坊市', '济宁市', '泰安市', '威海市', '日照市', '莱芜市', '临沂市', '德州市', '聊城市', '滨州市', '菏泽市'];

    china['河南省'] = ['郑州市', '开封市', '洛阳市', '平顶山市', '安阳市', '鹤壁市', '新乡市', '焦作市', '濮阳市', '许昌市', '漯河市', '三门峡市', '南阳市', '商丘市', '信阳市', '周口市', '驻马店市'];

    china['湖北省'] = ['武汉市', '黄石市', '十堰市', '荆州市', '宜昌市', '襄樊市', '鄂州市', '荆门市', '孝感市', '黄冈市', '咸宁市', '随州市'];

    china['湖南省'] = ['长沙市', '株洲市', '湘潭市', '衡阳市', '邵阳市', '岳阳市', '常德市', '张家界市', '益阳市', '郴州市', '永州市', '怀化市', '娄底市'];

    china['广东省'] = ['广州市', '深圳市', '珠海市', '汕头市', '韶关市', '佛山市', '江门市', '湛江市', '茂名市', '肇庆市', '惠州市', '梅州市', '汕尾市', '河源市', '阳江市', '清远市', '东莞市', '中山市', '潮州市', '揭阳市', '云浮市'];

    china['海南省'] = ['文昌市', '琼海市', '万宁市', '五指山市', '东方市', '儋州市'];

    china['四川省 '] = ['成都市', '自贡市', '攀枝花市', '泸州市', '德阳市', '绵阳市', '广元市', '遂宁市', '内江市', '乐山市', '南充市', '眉山市', '宜宾市', '广安市', '达州市', '雅安市', '巴中市', '资阳市'];

    china['贵州省'] = ['贵阳市', '六盘水市', '遵义市', '安顺市'];

    china['云南省'] = ['昆明市', '曲靖市', '玉溪市', '保山市', '昭通市', '丽江市', '普洱市', '临沧市'];

    china['陕西省'] = ['西安市', '铜川市', '宝鸡市', '咸阳市', '渭南市', '延安市', '汉中市', '榆林市', '安康市', '商洛市'];

    china['甘肃省'] = ['兰州市', '金昌市', '白银市', '天水市', '嘉峪关市', '武威市', '张掖市', '平凉市', '酒泉市', '庆阳市', '定西市', '陇南市'];

    china['青海省'] = new Array('西宁市');

    china['台湾省'] = ['台北市', '高雄市', '基隆市', '台中市', '台南市', '新竹市', '嘉义市'];

    china['广西壮族自治区'] = ['南宁市', '柳州市', '桂林市', '梧州市', '北海市', '防城港市', '钦州市', '贵港市', '玉林市', '百色市', '贺州市', '河池市', '来宾市', '崇左市'];

    china['内蒙古自治区'] = ['呼和浩特市', '包头市', '乌海市', '赤峰市', '通辽市', '鄂尔多斯市', '呼伦贝尔市', '巴彦淖尔市', '乌兰察布市'];

    china['西藏自治区'] = new Array('拉萨市');

    china['宁夏回族自治区'] = ['银川市', '石嘴山市', '吴忠市', '固原市', '中卫市'];

    china['新疆维吾尔自治区'] = ['乌鲁木齐市', '克拉玛依市'];

    china['香港特别行政区'] = ['台北市', '高雄市', '基隆市', '台中市', '台南市', '新竹市', '嘉义市'];


    let $areaLeft = $('.area-left');
    let $areaRight = $('.area-right');
    // 立即执行函数
    // 将省的数据导入地区的左侧选择框
    (function () {
        for (let i in china) {
            $areaLeft.append('<li class="area-clicked-false">' + i + '</li>');
        }
        $('.area-left>li').click(function () {
            // 获取之前所点击的元素
            let $clicked = $('.area-clicked-true');
            // 将js赋给该元素的 背景颜色修改 和 字体颜色修改 去除
            $clicked.attr('style', '');
            // 将该元素重新标记为未点击过
            $clicked.attr('class', 'area-clicked-false');
            // 修改点击元素的样式
            $(this).css('background-color', '#f0f0f0');
            $(this).css('color', 'blue');
            // 将所点击的元素标记
            $(this).attr('class', 'area-clicked-true');
            // 清空右侧框的元素
            $areaRight.empty();
            let areaName = $(this).text();
            for (let j in china[areaName]) {
                $areaRight.append('<li>' + china[areaName][j] + '</li>');
            }
            // 给框右侧的元素添加点击事件
            $('.area-right>li').click(function () {
                // 获取省市的值
                let province = $('.area-clicked-true').text();
                let city = $(this).text();
                // 将值赋予文本框
                $('.area-data').attr('value', province + '/' + city);
            })
        })
    })();

    // 监听表单内容是否变化
    $(function () {
        let initData = $("form").serialize();
        $("input").change(function () {
            let jsonFormCurr = $("form").serialize();
            if (jsonFormCurr !== initData) {
                $(".per-change-check").removeAttr("disabled");
            } else {
                $(".per-change-check").attr("disabled", "");
            }
        });
    });

    let $cancelAccount =  $(".log-out");
    $cancelAccount.mouseover(function () {
        $(".log-out").html("NOT ALLOWED")
    });
    $cancelAccount.mouseleave(function (){
        $(".log-out").html("账号注销")
    });
});

