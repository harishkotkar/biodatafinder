package com.kotkar.BiodataFinder.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@ToString
public class Profile {
    private String id;

    @NotNull(message = "First name field must not be null")
    @Size(min = 2, max=50, message = "First name field must be a valid value")
    private String firstName;

    @NotNull(message = "Middle name field must not be null")
    @Size(min = 2, max=50, message = "Middle name field must be valid value")
    private String middleName;

    @NotNull(message = "Last name field must not be null")
    @Size(min = 2, max=50, message = "Last name must be valid value")
    private String lastName;

    @NotNull(message = "Birthdate must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    //@Pattern(regexp = "MANDAV|GAHILAM|KHALAP|GAUTAM|KASCHYAP|LOKAKSH", message = "Gotra must be valid value")
    @Valid
    private Gotra gotra;

    //@Pattern(regexp = "A_POSITIVE|A_NEGATIVE|B_POSITIVE|B_NEGATIVE|AB_POSITIVE|AB_NEGATIVE|O_POSITIVE|O_NEGATIVE", message = "Blood Group must be valid value")
    @Valid
    private BloodGroup bloodGroup;

    @NotNull(message = "Current City field must not be null")
    @Size(min = 2, max=30, message = "Current city field must have valid value")
    private String currentCity;

    @NotNull(message = "Country field must not be null")
    @Size(min = 2, max=30, message = "Country field must have valid value")
    private String country;

    @DecimalMin(value= "12000", message = "Annual income field must have valid value")
    @DecimalMax(value = "990000000", message = "Annual income field must have valid value")
    private long annualIncome;


    @DecimalMin(value = "3", message = "Feet field must be valid value")
    @DecimalMax(value = "9", message = "Feet field must be valid value")
    private int heightFeet;

    @DecimalMin(value = "0", message = "Inches field must be valid value")
    @DecimalMax(value = "11", message = "Inches field must be valid value")
    private int heightInches;

}

