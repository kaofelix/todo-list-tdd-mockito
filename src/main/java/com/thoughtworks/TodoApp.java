package com.thoughtworks;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TodoApp {
    public static final String ADD_COMMAND = "add";
    public static final String LIST_COMMAND = "list";
    public static final String MARK_AS_DONE_COMMAND = "done";

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
        String command = commandAndArgument[0];

        if (ADD_COMMAND.equals(command)) {
            todoList.add(commandAndArgument[1]);
        } else if (LIST_COMMAND.equals(command)) {
            out.println(todoList.listAll());
        } else if (MARK_AS_DONE_COMMAND.equals(command)) {
            todoList.markAsDone(Integer.parseInt(commandAndArgument[1]));
        }
    }
}
