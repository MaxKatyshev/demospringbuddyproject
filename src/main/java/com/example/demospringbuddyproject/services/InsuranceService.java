package com.example.demospringbuddyproject.services;

import com.example.demospringbuddyproject.constants.Status;
import com.example.demospringbuddyproject.model.Insurance;
import com.example.demospringbuddyproject.model.Manager;
import com.example.demospringbuddyproject.repo.InsuranceRepository;
import com.example.demospringbuddyproject.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final ManagerRepository managerRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository,
                            ManagerRepository managerRepository) {
        this.insuranceRepository = insuranceRepository;
        this.managerRepository = managerRepository;
    }

    public Insurance create(Insurance insurance) {
        Long id = new Random().nextLong();
        Manager manager = managerRepository.findById(1L).orElse(null);
        insurance.setId(id);
        insurance.setStatus(Status.REQUESTED);
        insurance.setManager(manager);
        return insuranceRepository.save(insurance);
    }

    public Insurance changeInsuranceStatus(Long id, Status newStatus) {
        Insurance insurance = insuranceRepository.findById(id).orElse(null);
        assert insurance != null;
        insurance.setStatus(newStatus);
        return insuranceRepository.save(insurance);
    }

    public List<Insurance> getAllByManager(String lastName) {
        return insuranceRepository.findAllByManagerName(lastName);
    }

    public List<Insurance> getAllByName(String name) {
        return insuranceRepository.getAllByName(name);
    }
}
