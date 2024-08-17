package com.tony.hospitalapi.persons.controller;
import com.tony.hospitalapi.persons.dto.PersonCreationDto;
import com.tony.hospitalapi.persons.dto.PersonFetchDto;
import com.tony.hospitalapi.persons.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<?> getPersons(){
        List<PersonFetchDto> persons = personService.getPersons();
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<?> getPersonById(
            @PathVariable("personId") Integer personId
    ){
        PersonFetchDto person = personService.getPersonById(personId);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(
            @RequestBody PersonCreationDto dto
            ){

        personService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully created");
    }



}
