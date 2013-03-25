package com.thoughtworks;

public class TodoList {
    private TodoRepository todoRepository;
    private TodoFactory todoFactory;

    public TodoList(TodoRepository todoRepository, TodoFactory todoFactory) {
        this.todoRepository = todoRepository;
        this.todoFactory = todoFactory;
    }

    public void add(String todoDescription) {
        Todo todo = todoFactory.makeTodo(todoDescription);
        todoRepository.save(todo);
    }
}
