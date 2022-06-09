package com.codefellowship.CodeFellowShip.model;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String body;
    private Date timeStamp;

    @ManyToOne
    CodeFellowshipUser codeFellowshipUser;

    public Post() {
    }

    public Post(String body, Date timeStamp) {
        this.body = body;
        this.timeStamp = timeStamp;
    }

    public Post(String body, Date timeStamp, CodeFellowshipUser codeFellowshipUser) {
        this.body = body;
        this.timeStamp = timeStamp;
        this.codeFellowshipUser = codeFellowshipUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public CodeFellowshipUser getAppUser() {
        return codeFellowshipUser;
    }

    public void setAppUser(CodeFellowshipUser codeFellowshipUser) {
        this.codeFellowshipUser = codeFellowshipUser;
    }
}