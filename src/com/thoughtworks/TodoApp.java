package com.thoughtworks;

import java.io.InputStream;
import java.io.OutputStream;

public class TodoApp {
    private TodoList todoList;

    public TodoApp(InputStream in, OutputStream out, TodoList todoList) {
        this.todoList = todoList;
    }

    public void run() {
        todoList.add(new Todo("Foo"));
    }
}
