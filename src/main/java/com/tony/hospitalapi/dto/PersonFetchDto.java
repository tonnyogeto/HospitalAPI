package com.tony.hospitalapi.dto;

import lombok.Data;

@Data
public class PersonFetchDto {
    private String name;
    private String registrationNumber;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private Integer weight;



}
