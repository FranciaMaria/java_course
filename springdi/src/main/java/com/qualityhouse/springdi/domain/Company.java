package com.qualityhouse.springdi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="mfrancia_company")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    //@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
    //@JsonIgnore
    @OneToMany(cascade = ALL, mappedBy="company", fetch=FetchType.LAZY)
    private List<Employee> employees;

    public Company(){}

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

