package com.customer.marketing.retrievePreference.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {

    /* Created by suditi on 2021-08-13 */
    private Integer code;
    private String message;
    T data;

}
