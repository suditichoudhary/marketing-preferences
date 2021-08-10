package com.customer.marketing.publishPreference.controller;

import com.customer.marketing.publishPreference.entity.Response;
import com.customer.marketing.publishPreference.service.ChangeMarketingPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ChangeMarketingPrefController {

    /* Created by suditi on 2021-08-11 */

    public final ChangeMarketingPreferenceService changeMarketingPreferenceService;

    @Autowired
    public ChangeMarketingPrefController(ChangeMarketingPreferenceService changeMarketingPreferenceService) {
        this.changeMarketingPreferenceService = changeMarketingPreferenceService;
    }

    @PutMapping("/v1/marketing/preference")
    public ResponseEntity<?> updateMarketingPreference() {
        Response response = changeMarketingPreferenceService.updateMarketingPreference();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/v1/marketing/preference")
    public ResponseEntity<?> addMarketingPreference() {
        Response response = changeMarketingPreferenceService.addMarketingPreference();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
