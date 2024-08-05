package com.tony.hospitalapi.controller;
import com.tony.hospitalapi.dto.PersonFetchDto;
import com.tony.hospitalapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<?> getPersons(){
        List<PersonFetchDto> persons = personService.getPersons();
        return ResponseEntity.status(HttpStatus.OK).body(persons);



    }
}
