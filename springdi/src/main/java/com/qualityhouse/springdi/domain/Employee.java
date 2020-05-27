package com.qualityhouse.springdi.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="mfrancia_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

    public Employee() {}

    @Transient
    public String getFullName() {
        // return this.getFirstName() + " " + this.getLastName();
        return this.firstName + " " + this.lastName;
    }

}
