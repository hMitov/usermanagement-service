package com.paymentsystem.rest.controller;

import com.paymentsystem.rest.dto.Customer;
import com.paymentsystem.rest.dto.CustomerData;
import com.paymentsystem.rest.port.CustomerRestPort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(tags = {"customer"}, value = "Customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CustomerRestPort customerRestPort;


    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    @ApiOperation(value = "Add new customer", nickname = "createCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Customer.class),
            @ApiResponse(code = 500, message = "Error creating customers")})
    public Customer createCustomer(@RequestBody CustomerData data) throws Exception {
        return customerRestPort.createCustomer(data);
    }

    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get the customer with specific id", nickname = "getCustomerById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Customer.class),
            @ApiResponse(code = 400, message = "Invalid ID customer"),
            @ApiResponse(code = 404, message = "Customer not found")})
    public Customer getCustomerById(@PathVariable Long id) throws Exception {
        return customerRestPort.getCustomer(id);
    }


    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    @ApiOperation(value = "Get all customers", nickname = "getAllCustomers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Customer.class),
            @ApiResponse(code = 404, message = "Customers not found"),
            @ApiResponse(code = 500, message = "Error getting customers")})
    public List<Customer> getAllCustomers() {
        return customerRestPort.getAllCustomers();
    }



    @RequestMapping(path = "/customer", method = RequestMethod.PUT)
    @ApiOperation(value = "Update customer", nickname = "updateCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Customer.class),
            @ApiResponse(code = 500, message = "Error updating customers")})
    public Customer updateCustomer(@RequestBody CustomerData dataDto) throws Exception {
        return customerRestPort.updateCustomer(dataDto);
    }


    @RequestMapping(path = "/customer/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete customer by id", nickname = "deleteCustomer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Error deleting customers")})
    public void deleteCustomer(@PathVariable Long id) {
        customerRestPort.deleteCustomer(id);
    }

}

