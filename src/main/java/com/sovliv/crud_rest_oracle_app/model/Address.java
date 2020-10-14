package com.sovliv.crud_rest_oracle_app.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String postCode;
}
