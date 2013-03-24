package com.thoughtworks;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TodoListTest {

    @Test
    public void shouldAddNewTodos() throws Exception {
        Todo todo = new Todo("Buy milk");
        TodoRepository todoRepository = mock(TodoRepository.class);

        TodoList todoList = new TodoList(todoRepository);
        todoList.add(todo);

        verify(todoRepository).save(todo);
    }
}
