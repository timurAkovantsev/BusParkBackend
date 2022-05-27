package com.samsung.vatk.buspark.rest;

import com.samsung.vatk.buspark.domain.Driver;
import com.samsung.vatk.buspark.domain.dto.DriverDto;
import com.samsung.vatk.buspark.domain.mapper.DriverMapper;
import com.samsung.vatk.buspark.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private DriverService driverService;
    private DriverMapper driverMapper;

    public DriverController(DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @PostMapping
    public DriverDto create(@RequestBody DriverDto driverDto) {
        Driver driver = driverMapper.fromDto(driverDto);
        Driver createdDriver = driverService.create(driver);
        DriverDto driverDtoResult = driverMapper.toDto(createdDriver);
        return driverDtoResult;
    }

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable("id") Long id) {
        Driver driver = driverService.findById(id);
        DriverDto driverDto = driverMapper.toDto(driver);
        return driverDto;
    }

    @GetMapping
    public List<DriverDto> findAll() {
        List<Driver> drivers = driverService.findAll();
        List<DriverDto> driverDtoList = driverMapper.toDtoList(drivers);
        return driverDtoList;
    }

    @PutMapping
    public DriverDto update(@RequestBody DriverDto driverDto) {
        Driver driver = driverMapper.fromDto(driverDto);
        Driver updatedDriver = driverService.update(driver);
        DriverDto driverDtoResult = driverMapper.toDto(updatedDriver);
        return driverDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        driverService.deleteById(id);
    }
}
