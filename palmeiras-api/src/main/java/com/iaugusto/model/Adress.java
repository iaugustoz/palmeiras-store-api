package com.iaugusto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {

    private String street;
    private String district;
    private String zip;
    private String number;
    private String complement;
    private String city;
    private String state;
}
