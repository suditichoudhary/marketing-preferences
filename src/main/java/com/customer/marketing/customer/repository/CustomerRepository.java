package com.customer.marketing.customer.repository;

import com.customer.marketing.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    /* Created by suditi on 2021-08-11 */

    @Query(value = "SELECT * FROM customers where customers_email=:customers_email",nativeQuery = true)
    CustomerEntity findByEmail(@Param("customers_email") String email);

}
