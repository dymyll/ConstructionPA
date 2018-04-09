package com.example.dj954347.constructionprojectassistant;

import java.util.Date;
import java.util.UUID;

/**
 * Created by troyr on 4/4/2018.
 */

public class Worker {
    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mUsername;
    public String mPassword;


    public Worker() {
        this(UUID.randomUUID());
    }

    public Worker(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstname) {
        mFirstName = firstname;
    }

    public String getLatsName() {return mLastName;}

    public void setLastName(String lastname) {
        mLastName = lastname;
    }

    public String Username() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword () {
        return mPassword;
    }

    public void setPassword(String password){
        mPassword = password;
    }
}


