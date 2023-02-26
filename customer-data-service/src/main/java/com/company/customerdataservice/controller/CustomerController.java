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

//    @Autowired
//    CustomerRepository customerRepo;

    /**
     * HTTP Method: POST
     * Endpoint: "/customers"
     * Request body: new Customer object
     * Response body: newly added Customer object
     *
     * Response Status: 201 Created
     */
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customer;// customerRepo.save(customer);
    }


    /**
     * HTTP Method: PUT
     * Endpoint: "/customers"
     * Request body: updated Customer object
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer updatedCustomer)
    {
        // customerRepo.save(updatedCustomer);
    }

    /**
     * HTTP Method: DELETE
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @DeleteMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestBody Customer customer)
    {
        // customerRepo.delete(customer);
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
        // Optional<Customer> result =  customerRepo.findById(id);

        return null;// result.isPresent() ? result.get() : null;
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
        return null;// customerRepo.findByState(state);
    }
}
