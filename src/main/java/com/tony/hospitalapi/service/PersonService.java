package com.tony.hospitalapi.service;


import com.tony.hospitalapi.Repository.PersonRepository;
import com.tony.hospitalapi.dto.PersonFetchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<PersonFetchDto> getPersons() {
        personRepository.findAll();
    }
}
