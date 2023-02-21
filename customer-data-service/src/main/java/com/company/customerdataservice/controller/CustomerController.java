package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController
{
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
        return null;
    }


    /**
     * HTTP Method: PUT
     * Endpoint: "/customers/"
     * Request body: updated Customer object
     * Response body: newly updated Customer object
     *
     * Response Status: 204 No Content
     */

    /**
     * HTTP Method: DELETE
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */

    /**
     * HTTP Method: GET
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: Customer (if found)
     *
     * Response Status: 200 Ok
     */

    /**
     * HTTP Method: GET
     * Endpoint: "/customers/state/{state}"
     * Request body: n/a
     * Response body: List of Customers (if any)
     *
     * Response Status: 200 Ok
     */
}
