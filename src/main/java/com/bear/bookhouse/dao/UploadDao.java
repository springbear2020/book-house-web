package com.bear.bookhouse.dao;

import com.bear.bookhouse.pojo.Upload;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:29
 */
public interface UploadDao {
    /**
     * 保存用户图书上传记录
     *
     * @param upload 上传记录
     * @return 1 - 保存成功
     */
    int saveUpload(Upload upload);

    /**
     * 通过用户 id 查询用户上传记录，
     * 并指定起始位置和偏移量以获取分页数据
     *
     * @param userId 用户 id
     * @param begin  起始位置
     * @param offset 偏移量
     * @return Upload or null
     */
    List<Upload> listUploadThoughUserIdByBeginAndOffset(int userId, int begin, int offset);

    /**
     * 通过用户 id 获取用户上传记录总数
     *
     * @param userId 用户 id
     * @return 上传总记录数
     */
    int getUploadCountsByUserId(int userId);

    /**
     * 修改上传记录状态
     *
     * @param id    上传记录 id
     * @param state 状态
     * @return 1 - 修改成功
     */
    int updateUploadStateById(int id, String state);

    /**
     * 获取一条指定状态的上传记录
     *
     * @param state 上传记录状态
     * @return 上传记录 or null
     */
    Upload getOneUploadByState(String state);
}
