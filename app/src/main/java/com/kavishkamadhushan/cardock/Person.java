package com.kavishkamadhushan.cardock;

public class Person {

    private String userName;
    private String email;
    private String pwd;

    public Person(String userName, String email, String pwd) {
        this.userName = userName;
        this.email = email;
        this.pwd = pwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return this.pwd;
    }
}
