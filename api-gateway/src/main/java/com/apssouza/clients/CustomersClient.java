package com.apssouza.clients;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apssouza.pojos.Customers;


@FeignClient("customer")
public interface CustomersClient {

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customers> getAll();

    @RequestMapping(value = "/customer/search", method = RequestMethod.GET)
    public Customers getUserByEmail(@RequestParam("email") String email);

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    Customers createCustomer(Customers customers);
}
