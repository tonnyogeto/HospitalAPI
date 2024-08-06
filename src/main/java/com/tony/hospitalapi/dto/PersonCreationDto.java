package com.tony.hospitalapi.dto;


import com.tony.hospitalapi.model.Gender;
import com.tony.hospitalapi.model.MaritalStatus;
import lombok.Data;

@Data
public class PersonCreationDto {

    private String name;
    private String registrationNumber;
    private String dateOfBirth;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer weight;
}
