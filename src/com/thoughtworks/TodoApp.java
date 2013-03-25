package com.thoughtworks;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TodoApp {
    private PrintStream out;
    private TodoList todoList;
    private Scanner scanner;

    public TodoApp(InputStream in, PrintStream out, TodoList todoList) {
        this.out = out;
        this.todoList = todoList;
        this.scanner = new Scanner(in);
    }

    public void run() {
        String commandString = scanner.nextLine();
        String[] commandAndArgument = StringUtils.split(commandString, " ", 2);
        if ("add".equals(commandAndArgument[0])) {
            todoList.add(commandAndArgument[1]);
        } else if ("list".equals(commandAndArgument[0])) {
            out.println(todoList.listAll());
        }
    }
}
