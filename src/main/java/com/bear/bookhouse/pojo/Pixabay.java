package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 23:16
 */
public class Pixabay {
    private Integer id;
    private String condition;
    private String tags;
    private Integer views;
    private Integer downloads;
    private Integer collections;
    private Integer likes;
    private Integer comments;
    private Date addTime;
    private String url;

    public static final int ERROR = -1;

    public Pixabay() {
    }

    public Pixabay(Integer id, String condition, String tags, Integer views, Integer downloads, Integer collections, Integer likes, Integer comments, Date addTime, String url) {
        this.id = id;
        this.condition = condition;
        this.tags = tags;
        this.views = views;
        this.downloads = downloads;
        this.collections = collections;
        this.likes = likes;
        this.comments = comments;
        this.addTime = addTime;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pixabay{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", tags='" + tags + '\'' +
                ", views=" + views +
                ", downloads=" + downloads +
                ", collections=" + collections +
                ", likes=" + likes +
                ", comments=" + comments +
                ", addTime=" + addTime +
                ", url='" + url + '\'' +
                '}';
    }
}