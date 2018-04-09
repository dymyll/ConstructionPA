package com.example.dj954347.constructionprojectassistant;

import java.util.Date;
import java.util.UUID;
/**
 * Created by troyr on 4/1/2018.
 */

public class Project {
    private UUID mId;
    private String mName;
    private String mAddress;
    private String mDescription;
    public String mProjectStatus;
    public Date mCompletionDate;

    public Project() {
        this(UUID.randomUUID());
    }

    public Project(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {return mAddress;}

    public void setAddress(String address) {
        mAddress = address;
    }

    public String Description() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getProjectStatus () {
        return mProjectStatus;
    }

    public void setProjectStatus(String projectstatus){
        mProjectStatus = projectstatus;
    }

    public Date CompletetionDate(){
        return mCompletionDate;
    }

    public void setCompletetionDate(Date completiondate){
        mCompletionDate = completiondate;
    }
}


