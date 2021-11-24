package com.example.multipurposeapp;

public class users {String name,password,email,phone,feedback;
    public users() {

    }
    public users (String name,String password, String email, String phone, String feedback){
    this.name=name;
    this.password=password;
    this.email=email;
    this.phone=phone;
    this.feedback=feedback;
        }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }







}

