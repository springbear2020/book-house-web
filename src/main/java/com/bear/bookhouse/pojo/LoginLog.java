package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 17:19
 */
public class LoginLog {
    private Integer id;
    private Integer userId;
    private String username;
    private String ip;
    private String location;
    private Date time;

    public LoginLog() {
    }

    public LoginLog(Integer id, Integer userId, String username, String ip, String location, Date time) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.ip = ip;
        this.location = location;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}
