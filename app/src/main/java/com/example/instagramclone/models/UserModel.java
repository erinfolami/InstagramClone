package com.example.instagramclone.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserModel {

    public String id;
    public String username;
    public String email;


    public UserModel() {
        //constructor should be empty "required"
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UserModel(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
