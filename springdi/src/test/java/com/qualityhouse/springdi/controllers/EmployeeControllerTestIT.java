package com.qualityhouse.springdi.controllers;

import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.SpringDiApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringDiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTestIT {

    static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    int port;

    TestRestTemplate template = new TestRestTemplate();

    @Test
    void getById() throws JSONException {
        String expected = "Pan";
        String url = LOCAL_HOST + port + "/mfrancia_employee/1";
        ResponseEntity response = template.getForEntity(url, Employee.class);

        Employee employee = (Employee) response.getBody();

        System.out.println("LastName: " + employee.getLastName());
        assertEquals(expected, employee.getLastName());
    }
}
