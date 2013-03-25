package com.thoughtworks;

import org.junit.Test;

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
}
