package com.sarmaru.mihai.apiwithretrofit.models;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private int userID;
    @SerializedName("id")
    private int postID;
    @SerializedName("title")
    private String postTitle;
    @SerializedName("body")
    private String postContent;

    public int getUserID() {
        return userID;
    }

    public int getPostID() {
        return postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }
}
