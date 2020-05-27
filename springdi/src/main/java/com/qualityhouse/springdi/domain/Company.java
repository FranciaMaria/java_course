package com.qualityhouse.springdi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name="mfrancia_company")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = ALL, mappedBy="company", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    public Company(){}

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

