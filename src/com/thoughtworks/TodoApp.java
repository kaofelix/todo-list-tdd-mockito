package com.thoughtworks;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class TodoApp {
    private InputStream in;
    private TodoList todoList;
    private Scanner scanner;

    public TodoApp(InputStream in, OutputStream out, TodoList todoList) {
        this.in = in;
        this.todoList = todoList;
        this.scanner = new Scanner(in);
    }

    public void run() {
        String commandString = scanner.nextLine();
        String[] commandAndArgument = StringUtils.split(commandString, " ", 2);
        todoList.add(commandAndArgument[1]);
    }
}
