package com.example.recyclerviewemail;

public class Email {

    private String sender,subject,content,time;

    public Email(String sender, String subject, String content, String time){

        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.time = time;


    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
