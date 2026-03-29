package com.learninglogsterminal.entity;

import java.time.LocalDateTime;

public class Topic {

    // TODO 1: Declare fields
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // TODO 2: Constructor
    public Topic(int id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // TODO 3: Getters and Setter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    // TODO 4: toString()
    @Override
    public String toString() {
        return "[" + id + "] " + name + " (Created: " + createdAt + ")";
    }
}