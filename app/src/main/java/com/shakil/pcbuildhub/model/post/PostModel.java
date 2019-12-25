package com.shakil.pcbuildhub.model.post;

public class PostModel {
    private String title;
    private String postBy;
    private String date;

    public PostModel(String title, String postBy, String date) {
        this.title = title;
        this.postBy = postBy;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
