package com.thoughtworks;

public class Todo {
    private String description;

    public Todo(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
