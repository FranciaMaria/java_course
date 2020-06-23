package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    EmployeeService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new EmployeeServiceImpl(employeeRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    void findById() {

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setFirstName("Peter");
        mockEmployee.setLastName("Pan");

        when(employeeRepository.findById(ArgumentMatchers.eq(1))).thenReturn(java.util.Optional.of(mockEmployee));

        Optional<Employee> result = service.findById(1);
        String excepted = "{id:1, firstName:Peter, lastName:Pan}";

        System.out.println("Result: " + result);

        assertEquals(1, result.get().getId());
    }
}