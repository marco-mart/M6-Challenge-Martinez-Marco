package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController
{

    @Autowired
    CustomerRepository customerRepo;

    /**
     * HTTP Method: POST
     * Endpoint: "/customers"
     * Request body: Customer object
     * Response body: Customer object
     *
     * Response Status: 201 Created
     */
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerRepo.save(customer);
    }


    /**
     * HTTP Method: PUT
     * Endpoint: "/customers"
     * Request body: Customer object
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer updatedCustomer)
    {
        customerRepo.save(updatedCustomer);
    }

    /**
     * HTTP Method: DELETE
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id)
    {
        customerRepo.deleteById(id);
    }


    /**
     * HTTP Method: GET
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: Customer (if found)
     *
     * Response Status: 200 Ok
     */
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id)
    {
        Optional<Customer> result =  customerRepo.findById(id);

        return result.isPresent() ? result.get() : null;
    }

    /**
     * HTTP Method: GET
     * Endpoint: "/customers/state/{state}"
     * Request body: n/a
     * Response body: List of Customers (if any)
     *
     * Response Status: 200 Ok
     */
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state)
    {
        // customerRepo may return an empty list
        return customerRepo.findByState(state);
    }
}
