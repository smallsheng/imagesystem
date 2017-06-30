package com.example.shinelon.myapplication;

/**
 * Created by Shinelon on 2017/5/28.
 */


public class Picture {
    private String  name;
    private int imageId;

    public Picture(String name, int imageId){
        this.name=name;
        this.imageId=imageId;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
