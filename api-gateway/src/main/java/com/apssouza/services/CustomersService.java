package com.apssouza.services;

import java.util.List;

import com.apssouza.pojos.Customers;

/**
 *
 * @author mohammad
 */
public interface CustomersService {
    
    public List<Customers> getAll();

    public Customers getByCustomerEmail(String email);

    Customers createTodo(Customers customers);
}
