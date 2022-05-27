package com.samsung.vatk.buspark.domain.mapper;

import com.samsung.vatk.buspark.domain.Driver;
import com.samsung.vatk.buspark.domain.dto.DriverDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverMapper {

    public Driver fromDto(DriverDto driverDto) {
        Driver driver = new Driver();
        driver.setId(driverDto.getId());
        driver.setName(driverDto.getName());
        return driver;
    }


    public DriverDto toDto(Driver driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setId(driver.getId());
        driverDto.setName(driver.getName());
        return driverDto;
    }

    public List<DriverDto> toDtoList(List<Driver> driverList) {
        List<DriverDto> driverDtoList = new ArrayList<>();
        for (Driver driver :
                driverList) {
            driverDtoList.add(toDto(driver));
        }
        return driverDtoList;
    }
}
