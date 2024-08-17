package com.tony.hospitalapi.fatherchild;

import com.tony.hospitalapi.persons.model.Person;
import com.tony.hospitalapi.persons.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FatherChildService {

    @Autowired
    FatherChildRepository fatherChildRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void createFatherChild(FatherChildCreationDTO dto) {
        // Retrieve the father entity from the database using the father ID from the DTO
        Person father = personRepository.findById(dto.getFather())
                .orElseThrow(() -> new EntityNotFoundException("Father not found with ID: " + dto.getFather()));

        // Retrieve the child entity from the database using the child ID from the DTO
        Person child = personRepository.findById(dto.getChild())
                .orElseThrow(() -> new EntityNotFoundException("Child not found with ID: " + dto.getChild()));

        // Create the FatherChild entity and set the retrieved Person entities
        FatherChild fatherChild = new FatherChild();
        fatherChild.setFather(father);  // Set the father Person object
        fatherChild.setChild(child);    // Set the child Person object

        // Save the FatherChild entity to the database
        fatherChildRepository.save(fatherChild);

    }
}
