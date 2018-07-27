package com.hackathon.instagram.module.Post;

import com.hackathon.instagram.module.Post.Elements.Caption;
import com.hackathon.instagram.module.Post.Elements.Location;
import com.hackathon.instagram.module.Post.Elements.PostType;
import com.hackathon.instagram.module.Post.Elements.User;
import com.hackathon.instagram.module.Post.Elements.Image.ImagePack;

import java.util.ArrayList;

public class Post {
    private PostType postType;
    private ArrayList<Integer> users_in_photo = new ArrayList<>();
    private String filter;
    private ArrayList<String> tags = new ArrayList<>();
    private Caption caption;
    private int likes;
    private String link;
    private User user;
    private double created_time;
    private ArrayList<ImagePack> images = new ArrayList<>();
    private boolean userLiked;
    private int id;
    private Location location;


    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public ArrayList<Integer> getUsers_in_photo() {
        return users_in_photo;
    }

    public void setUsers_in_photo(ArrayList<Integer> users_in_photo) {
        this.users_in_photo = users_in_photo;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCreated_time() {
        return created_time;
    }

    public void setCreated_time(double created_time) {
        this.created_time = created_time;
    }

    public ArrayList<ImagePack> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImagePack> images) {
        this.images = images;
    }

    public boolean isUserLiked() {
        return userLiked;
    }

    public void setUserLiked(boolean userLiked) {
        this.userLiked = userLiked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
