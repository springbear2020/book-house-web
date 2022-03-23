package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/22 21:16
 */
public class Favorite {
    /**
     * 收藏记录 id
     */
    private Integer id;
    /**
     * 用户 id
     */
    private Integer userId;
    /**
     * 收藏的图书 id
     */
    private Integer bookId;
    /**
     * 收藏时间
     */
    private Date time;

    public Favorite() {
    }

    public Favorite(Integer id, Integer userId, Integer bookId, Date time) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", time=" + time +
                '}';
    }
}
