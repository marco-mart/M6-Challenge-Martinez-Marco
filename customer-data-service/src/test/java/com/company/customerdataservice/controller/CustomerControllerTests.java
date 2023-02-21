package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(Customer.class)
public class CustomerControllerTests
{

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests creating a new customer record and its response
     *
     * HTTP Method: POST
     * Endpoint: "/customers"
     * Request body: new Customer object
     * Response body: newly added Customer object
     *
     * Response Status: 201 Created
     */


    /**
     * Tests updating an existing customer record
     *
     * HTTP Method: PUT
     * Endpoint: "/customers/"
     * Request body: updated Customer object
     * Response body: newly updated Customer object
     *
     * Response Status: 204 No Content
     */

    /**
     * Tests Deleting an existing customer record
     *
     * HTTP Method: DELETE
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */

    /**
     * Tests finding a Customer by id
     *
     * HTTP Method: GET
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: Customer (if found)
     *
     * Response Status: 200 Ok
     */

    /**
     * Tests finding all customer records by State
     *
     * HTTP Method: GET
     * Endpoint: "/customers/state/{state}"
     * Request body: n/a
     * Response body: List of Customers (if any)
     *
     * Response Status: 200 Ok
     */
}
