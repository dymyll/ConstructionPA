package com.example.dj954347.constructionprojectassistant;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Dymyll on 4/9/2018.
 * //Testing
 */

public class Admin {
//Created this comment to test a merge
    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mEmailAddress;
    private Date mDateOfBirth;
    private String mPassword;
    private String mAdminName;

    public Admin() {
        this(UUID.randomUUID());
    }

    public Admin(UUID id) {
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

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String adminname) {
        mLastName = adminname;
    }

    public String getAdminName() {
        return mAdminName;
    }

    public void setAdminName(String username) {
        mAdminName = username;
    }


    public String getEmailAddress() {
        return mEmailAddress;
    }

    public void setEmailAddress(String emailaddress) {
        mEmailAddress = emailaddress;
    }

    public Date getDateofBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(Date dateofbirth) {
        mDateOfBirth = dateofbirth;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }



}
