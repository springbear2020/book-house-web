package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/27 11:35
 */
public class Admin {
   private Integer id;
   private String username;
   private String password;
   private Date registerDate;

   public Admin() {
   }

   public Admin(Integer id, String username, String password, Date registerDate) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.registerDate = registerDate;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Date getRegisterDate() {
      return registerDate;
   }

   public void setRegisterDate(Date registerDate) {
      this.registerDate = registerDate;
   }

   @Override
   public String toString() {
      return "Admin{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", registerDate=" + registerDate +
              '}';
   }
}
