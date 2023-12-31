package com.backend.tinkoff_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "userLogin", nullable = false, unique = true)
    private String userLogin;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userEmail", nullable = false)
    private String userEmail;

    @Column(name = "userPhoneNumber", nullable = false)
    private String userPhoneNumber;

    public User(){}

    public User(String userLogin,
                String userPassword,
                String userName,
                String userEmail,
                String userPhoneNumber) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }
}
