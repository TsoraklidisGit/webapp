package com.example.springboot.webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "tasos", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "tasos", "Learn Devops", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "tasos", "Learn Golang", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findbyUsername(String username) {
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equals(username);

        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, Boolean isItDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate,isItDone);
        todos.add(todo);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public Todo findbyId(int id) {
        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;

        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void deleteById (int id) {
        Predicate<? super Todo> predicate =
                todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

}
