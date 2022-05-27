package com.samsung.vatk.buspark.repository;


import com.samsung.vatk.buspark.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByName(String name);
}
