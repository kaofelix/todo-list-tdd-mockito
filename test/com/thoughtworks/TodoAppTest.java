package com.thoughtworks;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class TodoAppTest {

    private final TodoList todoList = mock(TodoList.class);
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(out);

    @Test
    public void shouldAddATask() throws Exception {
        TodoApp todoApp = new TodoApp(makeInputStream("add Buy milk"), printStream, todoList);
        todoApp.run();

        verify(todoList).add("Buy milk");
    }

    @Test
    public void shouldAddAnotherTask() throws Exception {
        TodoApp todoApp = new TodoApp(makeInputStream("add Prepare presentation about mockito"), printStream, todoList);
        todoApp.run();

        verify(todoList).add("Prepare presentation about mockito");
    }

    @Test
    public void shouldListTasks() throws Exception {
        given(todoList.listAll()).willReturn("1. Buy milk\n 2. Prepare presentation about mockito");

        TodoApp todoApp = new TodoApp(makeInputStream("list"), printStream, todoList);
        todoApp.run();

        assertThat(out.toString(), containsString("1. Buy milk\n 2. Prepare presentation about mockito"));
    }

    @Test
    public void shouldMarkATaskAsDone() throws Exception {
        TodoApp todoApp = new TodoApp(makeInputStream("done 1"), printStream, todoList);
        todoApp.run();

        verify(todoList).markAsDone(1);
    }

    @Test
    public void shouldMarkAnotherTaskAsDone() throws Exception {
        TodoApp todoApp = new TodoApp(makeInputStream("done 2"), printStream, todoList);
        todoApp.run();

        verify(todoList).markAsDone(2);
    }

    private BufferedInputStream makeInputStream(String content) {
        return new BufferedInputStream(new ByteArrayInputStream(content.getBytes()));
    }
}
