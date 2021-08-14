package com.customer.marketing;

import com.customer.marketing.customer.entity.CustomerEntity;
import com.customer.marketing.retrievePreference.entity.MarketingPreferenceEntity;
import com.customer.marketing.retrievePreference.entity.MarketingPreferenceModel;
import com.customer.marketing.retrievePreference.entity.Response;
import com.customer.marketing.retrievePreference.service.RetrievePreferenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketingApplicationTests {

    @Autowired
    RetrievePreferenceService retrievePreferenceService;

    @MockBean
    CustomerEntity customerEntity;
    @MockBean
    MarketingPreferenceEntity marketingPreferenceEntity;

    /* 1. Test to identify if customer exists */
    @Test
    public void getCustomerExists() {
        String emailAddress = "test5@gmail.com";
        CustomerEntity customerEntity = new CustomerEntity(5l,"test","test@gmail.com","dubai","585058688","test");
        Response response=retrievePreferenceService.getMarketingModelPreferenceByEmail(emailAddress);
        assertEquals("Email address doesn't exists!!",response.getMessage());
    }

    /* 2. Test to identify if customer Marketing Pref exists */
    @Test
    public void getMarketingPreferenceExists() {
        String emailAddress = "test2@gmail.com";
        customerEntity = new CustomerEntity(5l,"test","test2@gmail.com","dubai","585058688","test");
        Response response=retrievePreferenceService.getMarketingModelPreferenceByEmail(emailAddress);
        assertEquals("No marketing preferences for this Email!!",response.getMessage());
    }

    /* 3. Test to Get customer Marketing Pref list */
    @Test
    public void getMarketingPreferenceList() {
        String emailAddress = "test@gmail.com";
        CustomerEntity customerEntity = new CustomerEntity(5l,"test","test@gmail.com","dubai","585058688","test");
        marketingPreferenceEntity = new MarketingPreferenceEntity(2l,customerEntity,true,true,false);
        Response response=retrievePreferenceService.getMarketingModelPreferenceByEmail(emailAddress);
        assertEquals("success",response.getMessage());
    }


}
