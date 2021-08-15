This micrservice is mainly responsible to retrieve customer marketing preferences.

It has two Controllers :
1. Create/update/get customer details
2. Retrieve marketing preferences basis a customer email address

Specs :

Java version : 1.8 Spring Boot Application Mysql version : 8.0.12 Port : 8081

Main method : com.customer.marketing.MarketingApplication

Test class : com.customer.marketing.MarketingApplicationTests

--> Sample Request For retrieving pref :

1. curl -X GET \
  'http://localhost:8081/v1/marketing/preference?email=test2@gmail.com'

--> Sample Request For Customer details :

2. curl -X GET \
  'http://localhost:8081/v1/customer?email=test2@gmail.com'

  curl -X PUT \
  http://localhost:8081/v1/customer \
  -H 'Content-Type: application/json' \
  -d ' {
        "id": 2,
        "name": "Suditi",
        "email": "test2@gmail.com",
        "address": "abh",
        "mobile": "65452",
        "password": "test"
    }
'

3. curl -X POST \
  http://localhost:8081/v1/customer \
  -H 'Content-Type: application/json' \
   -d ' {
    
        "name": "Suditi",
        "email": "test3@gmail.com",
        "address": "abh",
        "mobile": null,
        "password": "test"
    }
'

Mysql schema :

create database marketing;

use marketing;

CREATE TABLE `customers` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `customers_name` varchar(32) NOT NULL DEFAULT '',
  `customers_email` varchar(96) NOT NULL DEFAULT '',
  `customers_address` varchar(400) DEFAULT NULL,
  `customers_password` text NOT NULL,
  `customers_mobile` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customers_email` (`customers_email`)
) ENGINE=InnoDB

insert into user_details values (null,'suditi','suditichoudhary@gmail.com',null,'Ghfhgg',7965547);


CREATE TABLE `marketing_preferences` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `customers_id` int(10) NOT NULL,
  `flag_post` tinyint(1) NOT NULL DEFAULT '0',
  `flag_sms` tinyint(1) NOT NULL DEFAULT '0',
  `flag_email` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `customers_id` (`customers_id`)
) ENGINE=InnoDB 

insert into marketing_preferences values (null,1,0,0,1);


--> Docker File added in the project

TEST CASES :

1. Test to identify if customer exists
2. Test to identify if customer Marketing Pref exists
3. Test to Get customer Marketing Pref list
