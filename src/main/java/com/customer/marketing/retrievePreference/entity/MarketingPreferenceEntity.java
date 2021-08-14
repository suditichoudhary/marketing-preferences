package com.customer.marketing.retrievePreference.entity;

import com.customer.marketing.customer.entity.CustomerEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="marketing_preferences")
public class MarketingPreferenceEntity {

    /* Created by suditi on 2021-08-13 */
    @Column(name = "id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "customers_id")
    private CustomerEntity customerEntity;
    @Column(name= "flag_post")
    private boolean flagPost;
    @Column(name= "flag_sms")
    private boolean flagSms;
    @Column(name= "flag_email")
    private boolean flagEmail;
}
