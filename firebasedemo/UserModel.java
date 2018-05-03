package com.example.googlemapdemo.firebasedemo;

/**
 * Created by Dell on 03-05-2018.
 */

public class UserModel {
    public static int userId=1;
    private int id;
    private String name;
    private String email;


    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
