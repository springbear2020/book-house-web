package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/25 22:01
 */
public class UserInfo {
   private Integer id;
   private Integer userId;
   private String nickname;
   private String sex;
   private Date birth;
   private String location;
   private String signature;
   private Integer collections;
   private Integer uploads;
   private Integer downloads;
   private Date lastUpdateTime;

   public static final int REGISTER_DEFAULT = 0;

   public UserInfo() {
   }

   public UserInfo(Integer id, Integer userId, String nickname, String sex, Date birth, String location, String signature, Date lastUpdateTime) {
      this.id = id;
      this.userId = userId;
      this.nickname = nickname;
      this.sex = sex;
      this.birth = birth;
      this.location = location;
      this.signature = signature;
      this.lastUpdateTime = lastUpdateTime;
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

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public Date getBirth() {
      return birth;
   }

   public void setBirth(Date birth) {
      this.birth = birth;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getSignature() {
      return signature;
   }

   public void setSignature(String signature) {
      this.signature = signature;
   }

   public Integer getCollections() {
      return collections;
   }

   public void setCollections(Integer collections) {
      this.collections = collections;
   }

   public Integer getUploads() {
      return uploads;
   }

   public void setUploads(Integer uploads) {
      this.uploads = uploads;
   }

   public Integer getDownloads() {
      return downloads;
   }

   public void setDownloads(Integer downloads) {
      this.downloads = downloads;
   }

   public Date getLastUpdateTime() {
      return lastUpdateTime;
   }

   public void setLastUpdateTime(Date lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
   }

   @Override
   public String toString() {
      return "UserInfo{" +
              "id=" + id +
              ", userId=" + userId +
              ", nickname='" + nickname + '\'' +
              ", sex='" + sex + '\'' +
              ", birth=" + birth +
              ", location='" + location + '\'' +
              ", signature='" + signature + '\'' +
              ", collections=" + collections +
              ", uploads=" + uploads +
              ", downloads=" + downloads +
              ", lastUpdateTime=" + lastUpdateTime +
              '}';
   }
}
