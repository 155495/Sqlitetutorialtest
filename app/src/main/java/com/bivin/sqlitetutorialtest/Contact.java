package com.bivin.sqlitetutorialtest;

/**
 * Created by bivin on 2/23/2018.
 */

public class Contact {
    int id;
    String name;
    String phonenumber;
    public Contact(int id, String name, String phonenumber) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
    }
    public Contact( String name, String phonenumber) {

        this.name = name;
        this.phonenumber = phonenumber;
    }
    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
