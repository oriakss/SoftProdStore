package com.softprod.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private  String name;

    @ManyToOne(cascade = ALL, optional = false)
    @JoinColumn(name = "SPECIALIZATION_ID")
    private Specialization specialization;

    public Student(String name, Specialization specialization) {
        this.name = name;
        this.specialization = specialization;
    }
}