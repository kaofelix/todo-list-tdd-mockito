package com.thoughtworks;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TodoListTest {

    @Test
    public void shouldAddNewTodos() throws Exception {
        Todo todo = new Todo("Buy milk");
        TodoFactory todoFactory = mock(TodoFactory.class);
        TodoRepository todoRepository = mock(TodoRepository.class);

        given(todoFactory.makeTodo("Buy milk")).willReturn(todo);

        TodoList todoList = new TodoList(todoRepository, todoFactory);
        todoList.add("Buy milk");

        verify(todoRepository).save(todo);
    }

    @Test
    public void shouldListTodos() throws Exception {
        TodoFactory todoFactory = mock(TodoFactory.class);
        TodoRepository todoRepository = mock(TodoRepository.class);

        given(todoRepository.all()).willReturn(asList(new Todo("Buy milk"), new Todo("Walk the dog")));

        TodoList todoList = new TodoList(todoRepository, todoFactory);
        String listAsString = todoList.listAll();

        assertThat(listAsString, is("1. Buy milk\n2. Walk the dog\n"));
    }
}
