package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.Download;
import com.bear.bookhouse.pojo.LoginLog;
import com.bear.bookhouse.pojo.Page;
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
     * @param userId   用户 id
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @return Download or null
     */
    Page<Download> listDownloadPageData(int userId, int pageNum, int pageSize);

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
     * @param userId   用户 id
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @return Upload or null
     */
    Page<Upload> listUploadPageData(int userId, int pageNum, int pageSize);

    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return true - 保存成功
     */
    boolean saveLoginLog(LoginLog loginLog);

    /**
     * 通过用户 id 查询用户登录日志并分页显示
     *
     * @param userId   用户 id
     * @param pageNum  页码
     * @param pageSize 每页显示的数量
     * @return 登录日志
     */
    Page<LoginLog> listLoginLogPageData(int userId, int pageNum, int pageSize);

    /**
     * 获取未处理的上传记录
     *
     * @return 图书上传记录
     */
    List<Upload> listUploadForAdmin();

    /**
     * 修改上传记录状态为已处理
     *
     * @param id    上传记录 id
     * @return 1 - 修改成功
     */
    int updateUploadState(int id);
}

