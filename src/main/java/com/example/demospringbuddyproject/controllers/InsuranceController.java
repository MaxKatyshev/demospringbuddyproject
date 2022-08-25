package com.example.demospringbuddyproject.controllers;

import com.example.demospringbuddyproject.constants.Status;
import com.example.demospringbuddyproject.dto.InsuranceDto;
import com.example.demospringbuddyproject.mappers.InsuranceMapper;
import com.example.demospringbuddyproject.model.Insurance;
import com.example.demospringbuddyproject.repo.InsuranceRepository;
import com.example.demospringbuddyproject.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

    private final InsuranceService insuranceService;
    private final InsuranceMapper insuranceMapper;
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceController(
            InsuranceService insuranceService,
            InsuranceMapper insuranceMapper,
            InsuranceRepository insuranceRepository
    ) {
        this.insuranceService = insuranceService;
        this.insuranceMapper = insuranceMapper;
        this.insuranceRepository = insuranceRepository;
    }

    @PostMapping("")
    public ResponseEntity<Object> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        try {
            Insurance insurance = insuranceMapper.insuranceDtoToInsurance(insuranceDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(insuranceService.create(insurance));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(insuranceRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PostMapping("/changeStatus")
    public Insurance changeInsuranceStatus(@RequestParam Long id, @RequestParam Status newStatus) {
        return insuranceService.changeInsuranceStatus(id, newStatus);
    }
}
