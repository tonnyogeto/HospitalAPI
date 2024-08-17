package com.tony.hospitalapi.persons.dto;

import com.tony.hospitalapi.persons.model.Gender;
import com.tony.hospitalapi.persons.model.MaritalStatus;
import lombok.Data;

@Data
public class PersonFetchDto {
    private String name;
    private String registrationNumber;
    private String dateOfBirth;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer weight;



}
