package com.qualityhouse.springdi.controllers;

import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.services.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeServiceImpl employeeServiceImpl;

    @Test
    void findById() throws Exception {
        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setFirstName("Peter");
        mockEmployee.setLastName("Pan");

        when(employeeServiceImpl.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(mockEmployee));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mfrancia_employee/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String excepted = "{id:1, firstName:Peter, lastName:Pan}";
        JSONAssert.assertEquals(excepted, result.getResponse().getContentAsString(), false);
    }

}