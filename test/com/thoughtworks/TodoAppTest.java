package com.thoughtworks;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TodoAppTest {
    @Test
    public void shouldAddATask() throws Exception {
        TodoList todoList = mock(TodoList.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TodoApp todoApp = new TodoApp(makeInputStream("add Buy milk"), out, todoList);
        todoApp.run();

        verify(todoList).add("Buy milk");
    }

    @Test
    public void shouldAddAnotherTask() throws Exception {
        TodoList todoList = mock(TodoList.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TodoApp todoApp = new TodoApp(makeInputStream("add Prepare presentation about mockito"), out, todoList);
        todoApp.run();

        verify(todoList).add("Prepare presentation about mockito");
    }

    private BufferedInputStream makeInputStream(String content) {
        return new BufferedInputStream(new ByteArrayInputStream(content.getBytes()));
    }
}
