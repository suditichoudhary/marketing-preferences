package com.customer.marketing.retrievePreference.repository;


import com.customer.marketing.retrievePreference.entity.MarketingPreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RetrievePreferenceRepository extends JpaRepository<MarketingPreferenceEntity,Long> {

    /* Created by suditi on 2021-08-12 */
    @Query(value = "SELECT * FROM marketing_preferences where customers_id=:customers_id ",nativeQuery = true)
     MarketingPreferenceEntity findByCustId(@Param("customers_id") long custId);

}
