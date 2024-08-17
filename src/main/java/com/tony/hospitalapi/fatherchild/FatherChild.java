package com.tony.hospitalapi.fatherchild;

import com.tony.hospitalapi.persons.model.Person;
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
@Table(name="father_child")
public class FatherChild {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "father_child_sequence_generator")
    @SequenceGenerator(name = "father_child_sequence_generator", sequenceName = "father_child_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="father_id")
    private Person father;

    @ManyToOne
    @JoinColumn(name="child_id")
    private Person child;
}
