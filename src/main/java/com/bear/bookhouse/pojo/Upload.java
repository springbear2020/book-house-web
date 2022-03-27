package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:28
 */
public class Upload {
   private Integer id;
   private Integer userId;
   private String username;
   private String operation;
   private String scoreChange;
   private Date time;
   private String title;
   private String bookPath;
   private String coverPath;
   private String state;

   public Upload() {
   }

   public Upload(Integer id, Integer userId, String username, String operation, String scoreChange, Date time, String title, String bookPath, String coverPath, String state) {
      this.id = id;
      this.userId = userId;
      this.username = username;
      this.operation = operation;
      this.scoreChange = scoreChange;
      this.time = time;
      this.title = title;
      this.bookPath = bookPath;
      this.coverPath = coverPath;
      this.state = state;
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

   public String getOperation() {
      return operation;
   }

   public void setOperation(String operation) {
      this.operation = operation;
   }

   public String getScoreChange() {
      return scoreChange;
   }

   public void setScoreChange(String scoreChange) {
      this.scoreChange = scoreChange;
   }

   public Date getTime() {
      return time;
   }

   public void setTime(Date time) {
      this.time = time;
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

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   @Override
   public String toString() {
      return "Upload{" +
              "id=" + id +
              ", userId=" + userId +
              ", username='" + username + '\'' +
              ", operation='" + operation + '\'' +
              ", scoreChange='" + scoreChange + '\'' +
              ", time=" + time +
              ", title='" + title + '\'' +
              ", bookPath='" + bookPath + '\'' +
              ", coverPath='" + coverPath + '\'' +
              ", state='" + state + '\'' +
              '}';
   }
}
