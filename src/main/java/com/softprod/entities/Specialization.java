package com.softprod.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
public class Specialization {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "DISCIPLINE_COUNT")
    private Integer disciplineCount;

    @OneToMany(mappedBy = "specialization", orphanRemoval = true, cascade = ALL,fetch = EAGER)
    private List<Student> students = new ArrayList<>();

    public Specialization(String name, Integer disciplineCount) {
        this.name = name;
        this.disciplineCount = disciplineCount;
    }

    public void addStudent(Student student) {
        student.setSpecialization(this);
        students.add(student);
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", disciplineCount=" + disciplineCount +
                '}';
    }
}