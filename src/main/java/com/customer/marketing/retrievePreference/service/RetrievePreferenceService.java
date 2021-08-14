package com.customer.marketing.retrievePreference.service;

import com.customer.marketing.customer.entity.CustomerEntity;
import com.customer.marketing.customer.service.CustomerService;
import com.customer.marketing.retrievePreference.entity.MarketingPreferenceEntity;
import com.customer.marketing.retrievePreference.entity.MarketingPreferenceModel;
import com.customer.marketing.retrievePreference.entity.Response;
import com.customer.marketing.retrievePreference.repository.RetrievePreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetrievePreferenceService {

    /* Created by suditi on 2021-08-12 */

    RetrievePreferenceRepository retrievePreferenceRepository;
    CustomerService customerService;

    @Autowired
    public RetrievePreferenceService(RetrievePreferenceRepository retrievePreferenceRepository, CustomerService customerService) {
        this.retrievePreferenceRepository = retrievePreferenceRepository;
        this.customerService = customerService;
    }

    public Response getMarketingPreferenceByEmail(String email){
        Response response = new Response();
        Response tempResponse = customerService.getCustomerDetailsByEmail(email);
        if(tempResponse.getMessage()!=null && tempResponse.getMessage().equals("success") && tempResponse.getData()!=null) {
            CustomerEntity customerEntity = (CustomerEntity) tempResponse.getData();
            if(customerEntity!=null && customerEntity.getId()!=null) {
                MarketingPreferenceEntity marketingPreferenceEntity = retrievePreferenceRepository.findByCustId(customerEntity.getId());
                if (marketingPreferenceEntity != null && marketingPreferenceEntity.getId() != null) {
                    response.setMessage("success");
                    response.setData(marketingPreferenceEntity);
                } else {
                    response.setMessage("No marketing preferences for this Email!!");
                }
            }else{
                response.setMessage("No details!!");
            }
        }else{
            response.setMessage("Email address doesn't exists!!");
        }
        response.setCode(HttpStatus.OK.value());
        return response;
    }

    public Response getMarketingModelPreferenceByEmail(String email){
        Response response = new Response();
        Response tempResponse = getMarketingPreferenceByEmail(email);
        if(tempResponse.getMessage()!=null && tempResponse.getMessage().equals("success") && tempResponse.getData()!=null) {
            MarketingPreferenceEntity marketingPreferenceEntity = (MarketingPreferenceEntity) tempResponse.getData();
            if (marketingPreferenceEntity != null && marketingPreferenceEntity.getId() != null) {
                response.setMessage("success");
                MarketingPreferenceModel marketingPreferenceModel = setUpMarketingPrefModel(marketingPreferenceEntity);
                response.setData(marketingPreferenceModel);
            }
        }else {
            response.setMessage(tempResponse != null ? tempResponse.getMessage() : "Something is not right");
        }
        response.setCode(HttpStatus.OK.value());
        return response;
    }
    public MarketingPreferenceModel setUpMarketingPrefModel(MarketingPreferenceEntity marketingPreferenceEntity){
        List<String> prefList = new ArrayList<>();
        MarketingPreferenceModel marketingPreferenceModel = new MarketingPreferenceModel();
        marketingPreferenceModel.setEmail(marketingPreferenceEntity.getCustomerEntity().getEmail());
        marketingPreferenceModel.setCustomersId(marketingPreferenceEntity.getCustomerEntity().getId());
        if(marketingPreferenceEntity.isFlagEmail()){
            prefList.add("email");
        }
        if(marketingPreferenceEntity.isFlagPost()){
            prefList.add("post");
        }
        if(marketingPreferenceEntity.isFlagSms()){
            prefList.add("sms");
        }

        marketingPreferenceModel.setPreferences(prefList);
        return marketingPreferenceModel;
    }
}
