package com.qualityhouse.springdi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.qualityhouse.springdi.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    List<Employee> findByName(String name);

    @Override
    Optional<Employee> findById(Integer integer);

}
