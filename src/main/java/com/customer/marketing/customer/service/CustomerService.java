package com.customer.marketing.customer.service;

import com.customer.marketing.customer.entity.CustomerEntity;
import com.customer.marketing.customer.repository.CustomerRepository;
import com.customer.marketing.publishPreference.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    /* Created by suditi on 2021-08-11 */

    public final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Response getCustomerDetailsByEmail(String emailAddress){
        Response response = new Response();
        if(emailAddress!=null && !emailAddress.isEmpty()) {
            CustomerEntity customerEntity =  customerRepository.findByEmail(emailAddress);
            if(customerEntity!=null && customerEntity.getId()!=null) {
                response.setMessage("success");
                response.setData(customerEntity);
            }else{
                response.setMessage("Wrong Email address!!");
            }
        }else{
            response.setMessage("Email address is mandatory!!");
        }
        response.setCode(HttpStatus.OK.value());
        return response;
    }

    public Response updateCustomerDetails(CustomerEntity customerEntity){
        Response response = new Response();
        if(customerEntity.getEmail()!=null && !customerEntity.getEmail().isEmpty()) {
            CustomerEntity customerEntityDB =  customerRepository.findByEmail(customerEntity.getEmail());
            if(customerEntityDB!=null && customerEntityDB.getId()!=null) {
                // update the details
                customerRepository.save(customerEntity);
                response.setMessage("success");
                response.setData(customerEntity);
            }else{
                response.setMessage("Wrong Email address!!");
            }
        }else{
            response.setMessage("Email address is mandatory!!");
        }
        response.setCode(HttpStatus.OK.value());
        return response;
    }

    public Response addNewCustomer(CustomerEntity customerEntity){
        Response response = new Response();
        if(customerEntity.getEmail()!=null && !customerEntity.getEmail().isEmpty()) {
            CustomerEntity customerEntityDB =  customerRepository.findByEmail(customerEntity.getEmail());
            if(customerEntityDB!=null && customerEntityDB.getId()!=null) {
                response.setMessage("Email address already exists!!");
            }else{
                // add new customer
                customerEntity = customerRepository.save(customerEntity);
                response.setMessage("success");
                response.setData(customerEntity);
            }
        }else{
            response.setMessage("Email address is mandatory!!");
        }
        response.setCode(HttpStatus.OK.value());
        return response;
    }

}
