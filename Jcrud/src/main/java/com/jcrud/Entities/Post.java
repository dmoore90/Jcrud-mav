package com.jcrud.Entities;

import javax.persistence.*;

@Entity
@Table(name="Posts")
public class Post {
    private long id;
    private String content;

    public Post() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
