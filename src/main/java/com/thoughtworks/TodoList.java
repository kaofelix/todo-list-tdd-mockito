package com.thoughtworks;

import java.util.List;
import java.util.ListIterator;

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

    public String listAll() {
        StringBuilder listBuilder = new StringBuilder();
        List<Todo> allTodos = todoRepository.all();
        ListIterator<Todo> it = allTodos.listIterator();
        while (it.hasNext()) {
            listBuilder.append(it.nextIndex() + 1);
            listBuilder.append(". ");
            listBuilder.append(it.next());
            listBuilder.append("\n");
        }

        return listBuilder.toString();
    }

    public void markAsDone(int taskIndex) {

    }
}
