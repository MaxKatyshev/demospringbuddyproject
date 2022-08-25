package com.example.demospringbuddyproject.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InsuranceController.class)
public class InsuranceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testCreateInsurance() throws Exception {
        mockMvc.perform(post("/api/v1/")
                        .param("insuranceDto", "<insuranceDto>"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/api/v1/all"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testChangeInsuranceStatus() throws Exception {
        mockMvc.perform(post("/api/v1/changeStatus")
                        .param("id", "<id>")
                        .param("newStatus", "<newStatus>"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
