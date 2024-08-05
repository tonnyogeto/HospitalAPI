package com.tony.hospitalapi.Repository;

import com.tony.hospitalapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
