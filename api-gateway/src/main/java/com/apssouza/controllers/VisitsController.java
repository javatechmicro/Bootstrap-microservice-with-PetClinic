package com.apssouza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apssouza.pojos.Todo;
import com.apssouza.pojos.Visits;
import com.apssouza.services.TodoService;
import com.apssouza.services.VisitService;

/**
 * User entry point
 *
 * @author Mohammad
 */
@RequestMapping("/visit")
@RestController
public class VisitsController {

    @Autowired
    VisitService visitService;

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Visits> all() {
        return this.visitService.getAll();
    }

    @GetMapping("/me")
    public List<Visits> me(OAuth2Authentication auth) {
        return this.visitService.getVisitsByEmaill(auth.getName());
    }

    @GetMapping("/me/todos")
    public List<Todo> todos(OAuth2Authentication auth) {
        return this.todoService.getTodoByUserEmaill(auth.getName());
    }

    @PostMapping("/me/todos")
    public Todo create(@RequestBody Todo todo) {
        return this.todoService.createTodo(todo);
    }
}
