package com.example.bookfuture.Model;

public class Account {
    private String userName;
    private String passWord;
    private String gmail;
    private String phoneNumber;

    public Account(String userName) {
        this.userName = userName;
    }

    public Account(String userName, String passWord, String gmail, String phoneNumber) {
        this.userName = userName;
        this.passWord = passWord;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
