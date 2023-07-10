package com.example.uas.models;

public class api {

    Integer userId, id;
    String title, body;

    public api(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {


        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }
}
