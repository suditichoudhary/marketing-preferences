package com.customer.marketing.retrievePreference.controller;

import com.customer.marketing.retrievePreference.entity.Response;
import com.customer.marketing.retrievePreference.service.RetrievePreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RetrievePreferenceController {

    /* Created by suditi on 2021-08-12 */

    RetrievePreferenceService retrievePreferenceService;

    @Autowired
    public RetrievePreferenceController(RetrievePreferenceService retrievePreferenceService) {
        this.retrievePreferenceService = retrievePreferenceService;
    }

    @GetMapping("/v1/marketing/preference")
    public ResponseEntity<?> getCustomerMarketingPreference(@RequestParam(defaultValue = "") String email) {
        Response response = new Response();
        if(email!=null)
            response = retrievePreferenceService.getMarketingModelPreferenceByEmail(email);
        else
            response.setMessage("Empty object!!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
