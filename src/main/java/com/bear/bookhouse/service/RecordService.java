package com.bear.bookhouse.service;

import com.bear.bookhouse.pojo.*;

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
    Page<Download> getDownloadPageData(int userId, int pageNum, int pageSize);

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
    Page<Upload> getUploadPageData(int userId, int pageNum, int pageSize);

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
    Page<LoginLog> getLoginLogPageData(int userId, int pageNum, int pageSize);

    /**
     * 修改上传记录状态为已处理
     *
     * @param id 上传记录 id
     * @return true - 修改成功
     */
    boolean updateUploadState(int id);

    /**
     * 获取第一条尚未处理的上传记录
     *
     * @param state 上传记录状态
     * @return 上传记录 or null
     */
    Upload getFirstNotProcessedUpload(String state);

    /**
     * 添加用户图书收藏记录
     *
     * @param favorite 收藏记录
     * @return true - 添加成功
     */
    boolean addFavorite(Favorite favorite);

    /**
     * 通过用户 id 和图书 id 判断收藏记录是否已存在
     *
     * @param userId 用户 id
     * @param booId  图书 id
     * @return true - 收藏记录已存在
     */
    boolean isFavoriteExists(int userId, int booId);

    /**
     * 通过用户 id 查询用户收藏记录
     *
     * @param userId 用户 id
     * @return Favorites or null
     */
    List<Favorite> getUserFavorites(int userId);

    /**
     * 删除用户图书收藏记录
     *
     * @param userId 用户 id
     * @param bookId 图书 id
     * @return true - 删除成功
     */
    boolean deleteUserFavorite(int userId, int bookId);
}

