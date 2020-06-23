package com.qualityhouse.springdi.controllers;

import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/mfrancia_employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/paged")
    public Page<Employee> getPage(Pageable pageable) {
        return this.employeeService.getPaged(pageable);
    }

//    @GetMapping("/byName/{name}")
//    public List<Employee> getByName(@PathVariable String name) {
//        return this.employeeService.getByName(name);
//    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findEmployee(@PathVariable Integer employeeId) {
        return this.employeeService.findById(employeeId);
    }

    @PostMapping
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        if (employeeService.exists(employee.getId())) {
            return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
        } else {
            Employee inserted = employeeService.insertEmployee(employee);
            return new ResponseEntity<Employee>(inserted, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("id = " + employeeId + " does not exist");
        }
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId){
        if (employeeService.exists(employeeId)) {
            Employee updated = employeeService.updateEmployee(employee, employeeId);
            return new ResponseEntity<Employee>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostConstruct
    public void postConstruct() {
        log.info("The EmployeeController instance is created.");
    }

}
