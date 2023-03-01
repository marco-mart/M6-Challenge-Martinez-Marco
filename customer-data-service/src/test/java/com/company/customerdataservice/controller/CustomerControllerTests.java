package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * We are only testing for the controller to send back the correct response because we test
     * the correctness of the Customer repository elsewhere.
     */

    /**
     * NOTE: WE DO NOT PROVIDE AN ID BECAUSE THE DATABASE AUTOMATICALLY GENERATES ONE FOR THE OBJECT.
     */

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
    @Test
    public void shouldCreateNewCustomer() throws Exception {

        // ARRANGE
        Customer customer1 = new Customer();
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

        String customerJson = mapper.writeValueAsString(customer1);

        // ACT
        mockMvc.perform(
                post("/customers")                          // Perform the POST request
                        .content(customerJson)                            // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)       // Tell the server that it is in JSON format
                )
                        .andDo(print())                                // Print results to console
                        .andExpect(status().isCreated());              // Assert status code is 201
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
    @Test
    public void shouldUpdateCustomer() throws Exception
    {
        // ARRANGE

        // PUT and POST on the repository side is the same function

        // Create new customer
        Customer customer = new Customer();
        customer.setFirstName("Marco");
        customer.setLastName("Martinez");
        customer.setEmail("nmfresh@gmail.com");
        customer.setCompany("Walmart");
        customer.setPhone("1-(575)123-4567");
        customer.setAddress1("1012 S Silver Ave");
        customer.setAddress2("123 Shelly Dr");
        customer.setCity("Deming");
        customer.setState("New Mexico");
        customer.setPostalCode("88030");
        customer.setCountry("United States");

        String customerJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                put("/customers")                                 // Perform the PUT request
                        .content(customerJson)                           // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)            // Tell the server that it is JSON format
        )
                .andDo(print())                                             // Print results to console
                .andExpect(status().isNoContent());                         // Assert status code is 204

    }

    /**
     * Tests Deleting an existing customer
     *
     * HTTP Method: DELETE
     * Endpoint: "/customers/{id}"
     * Request body: n/a
     * Response body: n/a
     *
     * Response Status: 204 No Content
     */
    @Test
    public void shouldDeleteCustomer() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT
        mockMvc.perform(
                delete("/customers/3")                        // Perform DELETE
        )
                .andDo(print())                                         // Print results to Console
                .andExpect(status().isNoContent());                     // Assert status code 204

    }

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
    @Test
    public void shouldFindCustomerById() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT

        mockMvc.perform(
                get("/customers/1")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

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
    @Test
    public void shouldFindAllCustomersByState() throws Exception
    {
        // ARRANGE

        // Because we test the repository elsewhere, we only test for the correct response.

        // ACT
        mockMvc.perform(
                get("/customers/state/New Mexico")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
