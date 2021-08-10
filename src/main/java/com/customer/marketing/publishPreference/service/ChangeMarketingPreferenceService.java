package com.customer.marketing.publishPreference.service;

import com.customer.marketing.publishPreference.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ChangeMarketingPreferenceService {

    /* Created by suditi on 2021-08-11 */

    public Response updateMarketingPreference(){
        Response response = new Response();
        response.setCode(HttpStatus.OK.value());
        return response;
    }

    public Response addMarketingPreference(){
        Response response = new Response();
        response.setCode(HttpStatus.OK.value());
        return response;
    }

}
