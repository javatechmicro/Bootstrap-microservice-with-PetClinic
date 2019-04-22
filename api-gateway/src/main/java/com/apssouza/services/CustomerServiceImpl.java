package com.apssouza.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apssouza.clients.CustomersClient;
import com.apssouza.pojos.Customers;
import com.apssouza.pojos.Todo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Customer service 
 * @author Mohammad
 */
@Component
public class CustomerServiceImpl implements CustomersService {

    @Autowired
    CustomersClient customerClient;

    @Override
    public List<Customers> getAll() {
        return customerClient.getAll();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackCustomer")
    public Customers getByCustomerEmail(String email) {
        return customerClient.getUserByEmail(email);
    }

    @Override
    public Customers createTodo(Customers customers) {
        return customerClient.createCustomer(customers);
    }

    public List<Todo> getFallbackCustomer(String email) {
        return Collections.emptyList();
    }
}
