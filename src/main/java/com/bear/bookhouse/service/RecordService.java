package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:46
 */
public interface RecordService {
   /**
    * 保存用户图书下载记录
    *
    * @param download 下载记录
    * @return true - 保存成功
    */
   boolean saveDownload(Download download);

   /**
    * 通过用户 id 查询用户下载记录
    *
    * @param userId 用户 id
    * @return Download or null
    */
   List<Download> listDownloadByUserId(int userId);

   /**
    * 保存用户图书上传记录
    *
    * @param upload 上传记录
    * @return true - 保存成功
    */
   boolean saveUpload(Upload upload);

   /**
    * 通过用户 id 查询用户上传记录
    *
    * @param userId 用户 id
    * @return Upload or null
    */
   List<Upload> listUploadByUserId(int userId);

   /**
    * 保存登录日志
    *
    * @param loginLog 登录日志
    * @return true - 保存成功
    */
   boolean saveLoginLog(LoginLog loginLog);

   /**
    * 通过用户 id 查询用户登录日志
    *
    * @param userId 用户 id
    * @return 登录日志
    */
   List<LoginLog> listLoginLogsByUserId(int userId);
}

