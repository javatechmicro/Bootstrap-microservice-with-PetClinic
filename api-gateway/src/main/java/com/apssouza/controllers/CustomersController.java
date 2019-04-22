package com.apssouza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apssouza.pojos.Customers;
import com.apssouza.pojos.Todo;
import com.apssouza.services.CustomersService;
import com.apssouza.services.TodoService;

/**
 * User entry point
 *
 * @author Mohammad
 */
@RequestMapping("/customer")
@RestController
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Customers> all() {
        return this.customersService.getAll();
    }

    @GetMapping("/me")
    public Customers me(OAuth2Authentication auth) {
        return this.customersService.getByCustomerEmail(auth.getName());
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
