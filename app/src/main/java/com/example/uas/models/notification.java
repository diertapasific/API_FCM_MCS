package com.example.uas.models;

public class notification {

    String title, body, time;

    public notification(String title, String body, String time) {
        this.title = title;
        this.body = body;
        this.time = time;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
