package com.samsung.vatk.buspark.domain.dto;


import lombok.Data;

@Data
public class BusDto {

    private Long id;

    private String name;

    private RouteDto routeDto;

    private DriverDto driverDto;
}
