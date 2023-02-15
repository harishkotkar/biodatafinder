package com.kotkar.BiodataFinder.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Profile {
    private String id;

    private String firstName;
    private String middleName;
    private String lastName;

    private Date birthDate;
    private Gotra gotra;
    private BloodGroup bloodGroup;
    private String currentCity;
    private String country;
    private long annualIncome;

}

