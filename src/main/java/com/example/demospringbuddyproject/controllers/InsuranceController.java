package com.example.demospringbuddyproject.controllers;

import com.example.demospringbuddyproject.dto.InsuranceDto;
import com.example.demospringbuddyproject.mappers.InsuranceMapper;
import com.example.demospringbuddyproject.model.Insurance;
import com.example.demospringbuddyproject.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private InsuranceMapper insuranceMapper;

    @PostMapping("")
    public ResponseEntity<Object> createInsurancePolicy(@RequestBody InsuranceDto insuranceDto) {
        try {
            Insurance insurance = insuranceMapper.insuranceDtoToInsurance(insuranceDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(insuranceService.create(insurance));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}