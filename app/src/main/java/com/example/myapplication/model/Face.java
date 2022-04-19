package com.example.myapplication.model;

public class Face {
    private int _id;
    private String email;
    private String password;
    private int count_sad;
    private int count_normal;
    private int count_happy;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount_sad() {
        return count_sad;
    }

    public void setCount_sad(int count_sad) {
        this.count_sad = count_sad;
    }

    public int getCount_normal() {
        return count_normal;
    }

    public void setCount_normal(int count_normal) {
        this.count_normal = count_normal;
    }

    public int getCount_happy() {
        return count_happy;
    }

    public void setCount_happy(int count_happy) {
        this.count_happy = count_happy;
    }

    public Face() {
        super();
    }

    public Face(int _id, String email, String password, int count_sad, int count_normal, int count_happy) {
        this._id = _id;
        this.email = email;
        this.password = password;
        this.count_sad = count_sad;
        this.count_normal = count_normal;
        this.count_happy = count_happy;
    }

    @Override
    public String toString() {
        return "Face{" +
                "_id=" + _id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", count_sad=" + count_sad +
                ", count_normal=" + count_normal +
                ", count_happy=" + count_happy +
                '}';
    }
}
