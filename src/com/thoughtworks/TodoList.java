package com.thoughtworks;

public class TodoList {
    private TodoRepository todoRepository;

    public TodoList(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void add(Todo todo) {
        todoRepository.save(todo);
    }
}
