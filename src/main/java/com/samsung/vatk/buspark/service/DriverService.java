package com.samsung.vatk.buspark.service;

import com.samsung.vatk.buspark.domain.Driver;
import com.samsung.vatk.buspark.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }


    public Driver findById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.isPresent() ? driver.get() : null;
    }


    public List<Driver> findAll() {
        return driverRepository.findAll();
    }


    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }


    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }
}
