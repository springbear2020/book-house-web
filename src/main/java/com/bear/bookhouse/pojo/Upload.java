package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/23 11:02
 */
public class Upload {
    private Integer id;
    private String uploadUsername;
    private Date uploadTime;
    private String bookPath;
    private String coverPath;

   public Upload() {
   }

   public Upload(Integer id, String uploadUsername, Date uploadTime, String bookPath, String coverPath) {
      this.id = id;
      this.uploadUsername = uploadUsername;
      this.uploadTime = uploadTime;
      this.bookPath = bookPath;
      this.coverPath = coverPath;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
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

   @Override
   public String toString() {
      return "Upload{" +
              "id=" + id +
              ", uploadUsername='" + uploadUsername + '\'' +
              ", uploadTime=" + uploadTime +
              ", bookPath='" + bookPath + '\'' +
              ", coverPath='" + coverPath + '\'' +
              '}';
   }
}
