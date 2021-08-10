package com.customer.marketing.publishPreference.repository;

import com.customer.marketing.publishPreference.entity.MarketingPreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangePreferenceRepository extends JpaRepository<MarketingPreferenceEntity,Long> {

    /* Created by suditi on 2021-08-11 */

}
