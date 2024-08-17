package com.tony.hospitalapi.persons.service;
import com.tony.hospitalapi.persons.repository.PersonRepository;
import com.tony.hospitalapi.persons.dto.PersonCreationDto;
import com.tony.hospitalapi.persons.dto.PersonFetchDto;
import com.tony.hospitalapi.persons.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<PersonFetchDto> getPersons() {
        List<Person> allPersons = personRepository.findAll();
        List<PersonFetchDto> dtos = new ArrayList<>();
        for (Person p : allPersons) {
            PersonFetchDto dto = convertToDto(p);
            dtos.add(dto);
        }
        return dtos;

    }

    public static PersonFetchDto convertToDto(Person p) {
        PersonFetchDto dto = new PersonFetchDto();
        dto.setName(p.getName());
        dto.setGender(p.getGender());
        dto.setWeight(p.getWeight());
        dto.setMaritalStatus(p.getMaritalStatus());
        dto.setRegistrationNumber(p.getRegistrationNumber());
        dto.setDateOfBirth(p.getDateOfBirth());
        return dto;
    }

    public PersonFetchDto getPersonById(Integer personId) {
        Person person = getPersonByIdOrElseThrow(personId);
        return convertToDto(person);
    }

    public Person getPersonByIdOrElseThrow(Integer personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        if (personOptional.isPresent()) {
            return personOptional.get();
        } else {
            throw new RuntimeException(String.format("Person with id %d not found", personId));
        }
    }

    @Transactional
    public void createUser(PersonCreationDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setGender(dto.getGender());
        person.setWeight(dto.getWeight());
        person.setMaritalStatus(dto.getMaritalStatus());
        person.setDateOfBirth(dto.getDateOfBirth());
        person.setRegistrationNumber(dto.getRegistrationNumber());
        personRepository.save(person);
    }

}
