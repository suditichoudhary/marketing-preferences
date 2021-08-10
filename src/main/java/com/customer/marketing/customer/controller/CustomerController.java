package com.customer.marketing.customer.controller;

import com.customer.marketing.customer.entity.CustomerEntity;
import com.customer.marketing.customer.service.CustomerService;
import com.customer.marketing.publishPreference.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    /* Created by suditi on 2021-08-11 */

    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/v1/customer")
    public ResponseEntity<?> getExistingCustomerDetails(@RequestParam(defaultValue = "") String emailAddress) {
        Response response = customerService.getCustomerDetailsByEmail(emailAddress);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/v1/customer")
    public ResponseEntity<?> updateCustomerDetails(@RequestBody CustomerEntity customerEntity) {
        Response response = customerService.updateCustomerDetails(customerEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/v1/customer")
    public ResponseEntity<?> addNewCustomer(@RequestBody CustomerEntity customerEntity) {
        Response response = customerService.addNewCustomer(customerEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
