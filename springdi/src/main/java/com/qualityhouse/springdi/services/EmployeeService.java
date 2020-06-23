package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();
    List<Employee> findAll();

    Page<Employee> getPaged(Pageable pageable);

//    List<Employee> getByName(String name);

    Optional<Employee> findById(Integer employeeId);

    Employee insertEmployee(Employee employee);

    void deleteEmployee(Integer employeeId);

    Employee updateEmployee(Employee employee, Integer employeeId);

    boolean exists(int id);

}