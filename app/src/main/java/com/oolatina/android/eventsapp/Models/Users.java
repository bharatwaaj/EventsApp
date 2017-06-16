package com.oolatina.android.eventsapp.Models;

/**
 * Created by Bharatwaaj on 15-06-2017.
 */

public class Users {

    public String name;
    public String uid;

    public Users(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
