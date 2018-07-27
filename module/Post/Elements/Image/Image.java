package com.hackathon.instagram.module.Post.Elements.Image;


public class Image {
    private String url = "";
    private int width = 0;
    private int height = 0;
    ImageType type;

    public Image(String url, int width, int height, ImageType type){
        this.url = url;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ImageType getType() {
        return type;
    }
}
