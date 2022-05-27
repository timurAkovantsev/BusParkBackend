package com.samsung.vatk.buspark.domain.mapper;

import com.samsung.vatk.buspark.domain.Bus;
import com.samsung.vatk.buspark.domain.dto.BusDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusMapper {

    private DriverMapper driverMapper;
    private RouteMapper routeMapper;

    public BusMapper(DriverMapper driverMapper, RouteMapper routeMapper) {
        this.driverMapper = driverMapper;
        this.routeMapper = routeMapper;
    }

    public Bus fromDto(BusDto busDto) {
        Bus bus = new Bus();
        bus.setId(busDto.getId());
        bus.setName(busDto.getName());
        bus.setDriver(driverMapper.fromDto(busDto.getDriverDto()));
        bus.setRoute(routeMapper.fromDto(busDto.getRouteDto()));
        return bus;
    }

    public BusDto toDto(Bus bus) {
        BusDto busDto = new BusDto();
        busDto.setId(bus.getId());
        busDto.setName(bus.getName());
        busDto.setDriverDto(driverMapper.toDto(bus.getDriver()));
        busDto.setRouteDto(routeMapper.toDto(bus.getRoute()));
        return busDto;
    }

    public List<BusDto> toDtoList(List<Bus> busList) {
        List<BusDto> busDtoList = new ArrayList<>();
        for (Bus bus :
                busList) {
            busDtoList.add(toDto(bus));
        }
        return busDtoList;
    }
}
