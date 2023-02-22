package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest
{
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception
    {
        customerRepo.deleteAll();
    }

    /**
     * Integration Test:
     * Testing the repository and database working together.
     */
    @Test
    public void addCustomer()
    {
        // Arrange

        // Act
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Joe");
        customer.setLastName("Shmoe");
        customer.setEmail("flyeaglesfly1@gmail.com");
        customer.setCompany("Nike");
        customer.setPhone("1-(215)619-3465");
        customer.setAddress1("102 Main St");
        customer.setAddress2("234 Iron St");
        customer.setCity("Philadelphia");
        customer.setState("Pennsylvania");
        customer.setPostalCode("19019");
        customer.setCountry("United States");

        // saves Customer to customer table and gives it a unique ID
        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        // Assert
        assertEquals(customer1.get(), customer);
    }
}