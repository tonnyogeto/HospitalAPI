package com.tony.hospitalapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence_generator")
    @SequenceGenerator(name = "person_sequence_generator", sequenceName = "person_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="registration_number")
    private String registrationNumber;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name="marital_status")
    private MaritalStatus maritalStatus;

    @Column(name="weight")
    private Integer weight;
}
