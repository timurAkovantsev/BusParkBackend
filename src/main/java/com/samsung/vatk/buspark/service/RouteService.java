package com.samsung.vatk.buspark.service;

import com.samsung.vatk.buspark.domain.Route;
import com.samsung.vatk.buspark.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    public Route create(Route route) {
        return routeRepository.save(route);
    }


    public Route findById(Long id) {
        Optional<Route> route = routeRepository.findById(id);
        return route.isPresent() ? route.get() : null;
    }


    public List<Route> findAll() {
        return routeRepository.findAll();
    }


    public Route update(Route route) {
        return routeRepository.save(route);
    }


    public void deleteById(Long id) {
        routeRepository.deleteById(id);
    }
}
