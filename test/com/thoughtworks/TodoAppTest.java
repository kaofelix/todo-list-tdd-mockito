package com.thoughtworks;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TodoAppTest {
    @Test
    public void shouldUnderstandTheAddCommand() throws Exception {
        TodoList todoList = mock(TodoList.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TodoApp todoApp = new TodoApp(makeInputStream("add"), out, todoList);
        todoApp.run();

        verify(todoList).add((Todo) anyObject());
    }

    private BufferedInputStream makeInputStream(String content) {
        return new BufferedInputStream(new ByteArrayInputStream(content.getBytes()));
    }
}
