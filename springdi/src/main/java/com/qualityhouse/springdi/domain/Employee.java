package com.qualityhouse.springdi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="mfrancia_employee")
public class Employee {

    // public Employee() {}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    @Transient
    public String getFullName() {
        // return this.getFirstName() + " " + this.getLastName();
        return this.firstName + " " + this.lastName;
    }

}
