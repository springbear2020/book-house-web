package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/26 10:27
 */
public class Download {
   private Integer id;
   private Integer userId;
   private String operation;
   private String scoreChange;
   private Date time;
   private String title;

   public static final int ERROR = -1;

   public Download() {
   }

   public Download(Integer id, Integer userId, String operation, String scoreChange, Date time, String title) {
      this.id = id;
      this.userId = userId;
      this.operation = operation;
      this.scoreChange = scoreChange;
      this.time = time;
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

   @Override
   public String toString() {
      return "Record{" +
              "id=" + id +
              ", userId=" + userId +
              ", operation='" + operation + '\'' +
              ", scoreChange='" + scoreChange + '\'' +
              ", time=" + time +
              ", title='" + title + '\'' +
              '}';
   }
}
