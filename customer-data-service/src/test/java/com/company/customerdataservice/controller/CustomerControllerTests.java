package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
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
     *
     * Note: we do not provide an id for the customer as the id
     *       get generated automatically.
     */
    @Test
    public void shouldCreateNewCustomer() throws Exception {

        // ARRANGE
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Joe");
        customer1.setLastName("Shmoe");
        customer1.setEmail("flyeaglesfly1@gmail.com");
        customer1.setCompany("Nike");
        customer1.setPhone("1-(215)619-3465");
        customer1.setAddress1("102 Main St");
        customer1.setAddress2("234 Iron St");
        customer1.setCity("Philadelphia");
        customer1.setState("Pennsylvania");
        customer1.setPostalCode("19019");
        customer1.setCountry("United States");

        String inputJson = mapper.writeValueAsString(customer1);

        // ACT
        MvcResult result = mockMvc.perform(
                post("/customers")                          // Perform the POST request
                        .content(inputJson)                            // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                        .andDo(print())                                // Print results to console
                        .andExpect(status().isCreated())               // Assert (status code is 201
                        .andReturn();                                  // Return result for testing

        System.out.println("BRUH " + result.getResponse().toString());
    }


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
