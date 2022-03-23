package com.bear.bookhouse.dao.impl;

import com.bear.bookhouse.dao.BaseDao;
import com.bear.bookhouse.dao.UploadDao;
import com.bear.bookhouse.pojo.Upload;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:05
 */
public class UploadDaoImpl extends BaseDao implements UploadDao {
   @Override
   public int saveBookUploadRecord(Upload upload) {
      String sql = "INSERT INTO `t_upload`(`upload_username`, `upload_time`,`book_path`,`cover_path`) VALUES (?,?,?,?);";
      return update(sql, upload.getUploadUsername(), upload.getUploadTime(), upload.getBookPath(), upload.getCoverPath());
   }
}
