package com.customer.marketing.customer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="customers")
public class CustomerEntity{

    /* Created by suditi on 2021-08-11 */

    @Column(name = "id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "customers_name")
    private String name;
    @Column(name= "customers_email")
    private String email;
    @Column(name= "customers_address")
    private String address;
    @Column(name= "customers_mobile")
    private String mobile;
    @Column(name= "customers_password")
    private String password;
}
