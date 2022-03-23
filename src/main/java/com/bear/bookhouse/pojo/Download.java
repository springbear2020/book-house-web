package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 19:07
 */
public class Download {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date downloadTime;
    private String title;

    public Download() {
    }

    public Download(Integer id, Integer userId, Integer bookId, Date downloadTime, String title) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.downloadTime = downloadTime;
        this.title = title;
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Download{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", downloadTime=" + downloadTime +
                ", title='" + title + '\'' +
                '}';
    }
}
