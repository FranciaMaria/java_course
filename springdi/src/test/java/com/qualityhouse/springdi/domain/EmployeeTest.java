package com.qualityhouse.springdi.domain;

import com.qualityhouse.springdi.repositories.EmployeeRepository;
import com.qualityhouse.springdi.services.EmployeeService;
import com.qualityhouse.springdi.services.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeTest {

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    @AfterEach
    void tearDown() {
    }

    @Mock
    Employee mockedEmployee = new Employee();

    public Employee getMockedEmployee() {
        System.out.println(mockedEmployee);
        return mockedEmployee;
    }

    @Test
    void getId() {

        when(mockedEmployee.getId()).thenReturn(1);

       Integer resultID = mockedEmployee.getId();

        System.out.println("Result: " + resultID);

       assertEquals(1, resultID);
    }

    @Test
    void getFirstName() {

        when(mockedEmployee.getFirstName()).thenReturn("Peter");

        String resultFirstName = mockedEmployee.getFirstName();

        System.out.println("Result: " + resultFirstName);

        assertEquals("Peter", resultFirstName);
    }

    @Test
    void getLastName() {

        when(mockedEmployee.getLastName()).thenReturn("Pan");

        String resultLastName = mockedEmployee.getLastName();

        System.out.println("Result: " + resultLastName);

        assertEquals("Pan", resultLastName);
    }

}