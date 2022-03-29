package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/29 15:25
 */
public class Background {
    private Integer id;
    private String sentence;
    private String path;
    private String uploadUser;
    private Date uploadTime;

    public static final int ERROR = -1;

    public Background() {
    }

    public Background(Integer id, String sentence, String path, String uploadUser, Date uploadTime) {
        this.id = id;
        this.sentence = sentence;
        this.path = path;
        this.uploadUser = uploadUser;
        this.uploadTime = uploadTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Background{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                ", path='" + path + '\'' +
                ", uploadUser='" + uploadUser + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
