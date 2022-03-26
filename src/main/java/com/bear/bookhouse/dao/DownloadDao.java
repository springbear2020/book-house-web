package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.Record;
import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:29
 */
public interface DownloadDao {
   /**
    * 保存用户图书下载记录
    *
    * @param download 下载记录
    * @return 1 - 保存成功
    */
   int saveDownload(Download download);

   /**
    * 通过用户 id 查询用户下载记录
    *
    * @param userId 用户 id
    * @return Download or null
    */
   List<Download> listDownloadByUserId(int userId);
}
