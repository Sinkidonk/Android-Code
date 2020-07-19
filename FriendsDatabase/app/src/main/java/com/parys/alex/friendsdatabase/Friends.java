package com.parys.alex.friendsdatabase;

/**
 * Created by apary on 12/4/2017.
 */

public class Friends {
    int id;
    String name;
    String email;

    public Friends(){

    }

    public Friends(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // constructor
    public Friends(String name, String email){
        this.name = name;
        this.email = email;
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
}
