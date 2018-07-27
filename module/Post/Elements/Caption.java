package com.hackathon.instagram.module.Post.Elements;

public class Caption {

    private int created_time;
    private String text;
    private String fromUser;
    private int id;

    public int getCreated_time() {
        return created_time;
    }

    public String getText() {
        return text;
    }

    public String getFromUser() {
        return fromUser;
    }

    public Caption(int created_time, String text, String fromUser, int id) {
        this.created_time = created_time;
        this.text = text;
        this.fromUser = fromUser;
        this.id = id;
    }

    public int getId() {

        return id;
    }


}
