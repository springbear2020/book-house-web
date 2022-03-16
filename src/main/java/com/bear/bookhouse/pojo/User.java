package com.bear.bookhouse.pojo;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 18:36
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date registerDate;

    public User() {
    }

    public User(Integer id, String username, String password, String email, Date registerDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
