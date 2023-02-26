package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Optional;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
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
    public void shouldCreateCustomer()
    {
        // Arrange

        // Act
        Customer customer = new Customer();
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

        // we use optional because it is not certain that we will get anything back
        Optional<Customer> customerCopy = customerRepo.findById(customer.getId());

        // Assert
        assertEquals(customerCopy.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer()
    {
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

        // get customer back with id
        Customer originalCustomer = customerRepo.save(customer);

        // ACT


        // update originalCustomer
        originalCustomer.setCity("Las Cruces");

        // update originalCustomer in repo
        Customer result = customerRepo.save(originalCustomer);

        // Assert
        Assert.assertEquals(originalCustomer, result);
    }

    @Test
    public void shouldDeleteCustomer()
    {
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

        // get customer back with id
        Customer originalCustomer = customerRepo.save(customer);

        // ACT

        // delete originalCustomer
        customerRepo.delete(originalCustomer);

        // Query DB for deleted customer
        Optional<Customer> result = customerRepo.findById(originalCustomer.getId());

        // Assert that customer was deleted
        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void shouldFindCustomerById()
    {
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

        // get customer back with id and save customer
        Customer originalCustomer = customerRepo.save(customer);


        // ACT

        // find customer by id
        Optional<Customer> result = customerRepo.findById(originalCustomer.getId());

        // Assert that customer was found by id
        Assert.assertEquals(originalCustomer, result.get());
    }

    @Test
    public void shouldFindCustomersByState()
    {
        // Create new customer
        Customer customer1 = new Customer();
        customer1.setFirstName("Marco");
        customer1.setLastName("Martinez");
        customer1.setEmail("nmfresh@gmail.com");
        customer1.setCompany("Walmart");
        customer1.setPhone("1-(575)123-4567");
        customer1.setAddress1("1012 S Silver Ave");
        customer1.setAddress2("123 Shelly Dr");
        customer1.setCity("Deming");
        customer1.setState("New Mexico");
        customer1.setPostalCode("88030");
        customer1.setCountry("United States");

        // get customer back with id
        Customer originalCustomer1 = customerRepo.save(customer1);

        // Create new customer
        Customer customer2 = new Customer();
        customer2.setFirstName("Rylan");
        customer2.setLastName("Larko");
        customer2.setEmail("drakefan@gmail.com");
        customer2.setCompany("Chico's Tacos");
        customer2.setPhone("1-(575)891-1121");
        customer2.setAddress1("500 N Golf St");
        customer2.setAddress2("789 Locust Ave");
        customer2.setCity("Taos");
        customer2.setState("New Mexico");
        customer2.setPostalCode("91001");
        customer2.setCountry("United States");

        // get customer back with id
        Customer originalCustomer2 = customerRepo.save(customer2);

        // Create new customer
        Customer customer3 = new Customer();
        customer3.setFirstName("Joe");
        customer3.setLastName("Song");
        customer3.setEmail("arduino4life@gmail.com");
        customer3.setCompany("Subway");
        customer3.setPhone("1-(575)494-2751");
        customer3.setAddress1("2330 S Valley Dr");
        customer3.setAddress2("707 S Telshor");
        customer3.setCity("New York");
        customer3.setState("New York");
        customer3.setPostalCode("10001");
        customer3.setCountry("United States");

        // get customer back with id
        Customer originalCustomer3 = customerRepo.save(customer3);

        // ACT

        Assert.assertTrue(customerRepo.findByState("New Mexico").size() == 2);

        Assert.assertTrue(customerRepo.findByState("New York").size() == 1);


    }
}