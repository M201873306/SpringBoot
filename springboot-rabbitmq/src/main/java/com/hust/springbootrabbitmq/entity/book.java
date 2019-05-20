package com.hust.springbootrabbitmq.entity;

import java.io.Serializable;

public class book implements Serializable {
    private String name;
    private String author;

    public book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public book(String name) {
        this.name = name;
    }
    public book() {

    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
