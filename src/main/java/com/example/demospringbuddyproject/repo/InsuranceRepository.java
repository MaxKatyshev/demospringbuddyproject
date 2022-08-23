package com.example.demospringbuddyproject.repo;

import com.example.demospringbuddyproject.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    @Override
    Optional<Insurance> findById(@NonNull Long id);

    @Query("select i from Insurance i where i.manager.lastName = ?1")
    List<Insurance> findAllByManagerName(String lastName);

    List<Insurance> getAllByName(String name);
}