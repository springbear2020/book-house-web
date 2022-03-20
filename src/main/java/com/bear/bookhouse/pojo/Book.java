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
    private String keywords;
    private String bookPath = "D:/Book/book/";
    private String bookCoverPath = "D:/Book/cover/";
    private String uploadUsername;
    private Date uploadTime;

    public Book() {
    }

    public Book(Integer id, String title, String author, String keywords, String bookPath, String bookCoverPath, String uploadUsername, Date uploadTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.keywords = keywords;
        this.bookPath = bookPath;
        this.bookCoverPath = bookCoverPath;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public String getBookCoverPath() {
        return bookCoverPath;
    }

    public void setBookCoverPath(String bookCoverPath) {
        this.bookCoverPath = bookCoverPath;
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
                ", keywords='" + keywords + '\'' +
                ", bookPath='" + bookPath + '\'' +
                ", bookCoverPath='" + bookCoverPath + '\'' +
                ", uploadUsername='" + uploadUsername + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
