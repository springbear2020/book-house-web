package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/20 19:10
 */
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String translator;
    private String keywords;
    private Integer downloads;
    private Integer collections;
    private String comment;
    private String bookPath;
    private String coverPath;
    private String uploadUsername;
    private Date uploadTime;

    public static final int ERROR = -1;
    public static final int PAGE_SIZE = 5;
    public static final int ADD_DOWNLOAD = 1;
    public static final int ADD_Favorite = 1;

    public Book() {
    }

    public Book(Integer id, String title, String author, String translator, String keywords, Integer downloads, Integer collections, String comment, String bookPath, String coverPath, String uploadUsername, Date uploadTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.translator = translator;
        this.keywords = keywords;
        this.downloads = downloads;
        this.collections = collections;
        this.comment = comment;
        this.bookPath = bookPath;
        this.coverPath = coverPath;
        this.uploadUsername = uploadUsername;
        this.uploadTime = uploadTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getUploadUsername() {
        return uploadUsername;
    }

    public void setUploadUsername(String uploadUsername) {
        this.uploadUsername = uploadUsername;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", keywords='" + keywords + '\'' +
                ", downloads=" + downloads +
                ", collections=" + collections +
                ", comment='" + comment + '\'' +
                ", bookPath='" + bookPath + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", uploadUsername='" + uploadUsername + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
