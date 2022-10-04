package com.example.book_app.Models;

import android.provider.ContactsContract;

public class Datatypes {
     String image;




    String name;
    String url;

    public Datatypes(String image, String name, String url) {
        this.image = image;
        this.name = name;
        this.url = url;

    }
    public Datatypes(){}
    public  String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name.substring(0,Math.min(name.length(),12));
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }}




