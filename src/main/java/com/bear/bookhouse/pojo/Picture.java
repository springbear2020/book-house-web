package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/18 19:03
 */
public class Picture {
    private Integer id;
    private Integer views;
    private Integer downloads;
    private Integer collections;
    private Integer likes;
    private Integer comments;
    private String tags;
    private Integer width;
    private Integer height;
    private Integer size;
    private String url;
    private Date addTime;

    public Picture() {
    }

    public Picture(Integer id, Integer views, Integer downloads, Integer collections, Integer likes, Integer comments, String tags, Integer width, Integer height, Integer size, String url, Date addTime) {
        this.id = id;
        this.views = views;
        this.downloads = downloads;
        this.collections = collections;
        this.likes = likes;
        this.comments = comments;
        this.tags = tags;
        this.width = width;
        this.height = height;
        this.size = size;
        this.url = url;
        this.addTime = addTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", views=" + views +
                ", downloads=" + downloads +
                ", collections=" + collections +
                ", likes=" + likes +
                ", comments=" + comments +
                ", tags='" + tags + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
