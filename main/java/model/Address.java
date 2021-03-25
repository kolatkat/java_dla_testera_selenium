package model;

import lombok.Data;

@Data
public class Address {
    private String address1;
    private String city;
    private String state;
    private String zip;
    private String country;
}
