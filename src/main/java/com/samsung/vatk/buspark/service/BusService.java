package com.samsung.vatk.buspark.service;

import com.samsung.vatk.buspark.domain.Bus;
import com.samsung.vatk.buspark.domain.Driver;
import com.samsung.vatk.buspark.domain.Route;
import com.samsung.vatk.buspark.repository.BusRepository;
import com.samsung.vatk.buspark.repository.DriverRepository;
import com.samsung.vatk.buspark.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    private BusRepository busRepository;
    private RouteRepository routeRepository;
    private DriverRepository driverRepository;

    public BusService(BusRepository busRepository, RouteRepository routeRepository, DriverRepository driverRepository) {
        this.busRepository = busRepository;
        this.routeRepository = routeRepository;
        this.driverRepository = driverRepository;
    }

    @Transactional
    public Bus create(Bus bus) {
        return busRepository.save(bus);
    }


    public Bus create(String busName, String routeName, String driverName) {

        Route route = routeRepository.findByName(routeName);
        if (route == null) {
            route = Route.builder()
                    .name(routeName)
                    .build();
        }

        Driver driver = driverRepository.findByName(driverName);
        if (driver == null) {
            driver = Driver.builder()
                    .name(driverName)
                    .build();
        }

        Bus bus = Bus.builder()
                .name(busName)
                .route(route)
                .driver(driver)
                .build();

        return busRepository.save(bus);
    }

    public Bus findById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        return bus.isPresent() ? bus.get() : null;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Transactional
    public Bus update(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus update(Long id, String newBusName, String newRouteName, String newDriverName) {
        Bus bus = Bus.builder()
                .id(id)
                .name(newBusName)
                .route(routeRepository.findByName(newRouteName))
                .driver(driverRepository.findByName(newDriverName))
                .build();

        return busRepository.save(bus);
    }


    public void deleteById(Long id) {
        busRepository.deleteById(id);
    }

}
