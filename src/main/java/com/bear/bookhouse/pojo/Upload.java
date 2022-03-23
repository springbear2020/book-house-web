package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 20:44
 */
public class Upload {
    private Integer id;
    private Integer userId;
    private Date uploadTime;
    private String title;
    private String bookPath;
    private String coverPath;

    public Upload() {
    }

    public Upload(Integer id, Integer userId, Date uploadTime, String title, String bookPath, String coverPath) {
        this.id = id;
        this.userId = userId;
        this.uploadTime = uploadTime;
        this.title = title;
        this.bookPath = bookPath;
        this.coverPath = coverPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id=" + id +
                ", userId=" + userId +
                ", uploadTime=" + uploadTime +
                ", title='" + title + '\'' +
                ", bookPath='" + bookPath + '\'' +
                ", coverPath='" + coverPath + '\'' +
                '}';
    }
}
