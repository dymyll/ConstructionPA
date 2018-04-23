package com.example.dj954347.constructionprojectassistant;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class Customer {

    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mEmailAddress;
    private Date mDateOfBirth;
    private String mPassword;
    private String mUserName;
    private boolean mSolved;

    public Customer() {
        this(UUID.randomUUID());
    }

    public Customer(UUID id) {
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

    public void setLastName(String lastname) {
        mLastName = lastname;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String username) {
        mUserName = username;
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

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }


}
