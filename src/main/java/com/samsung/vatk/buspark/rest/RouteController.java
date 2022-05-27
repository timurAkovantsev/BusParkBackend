package com.samsung.vatk.buspark.rest;

import com.samsung.vatk.buspark.domain.Route;
import com.samsung.vatk.buspark.domain.dto.RouteDto;
import com.samsung.vatk.buspark.domain.mapper.RouteMapper;
import com.samsung.vatk.buspark.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private RouteService routeService;
    private RouteMapper routeMapper;

    public RouteController(RouteService routeService, RouteMapper routeMapper) {
        this.routeService = routeService;
        this.routeMapper = routeMapper;
    }

    @PostMapping
    public RouteDto create(@RequestBody RouteDto routeDto) {
        Route route = routeMapper.fromDto(routeDto);
        Route createdRoute = routeService.create(route);
        RouteDto routeDtoResult = routeMapper.toDto(createdRoute);
        return routeDtoResult;
    }

    @GetMapping("/{id}")
    public RouteDto findById(@PathVariable("id") Long id) {
        Route route = routeService.findById(id);
        RouteDto routeDto = routeMapper.toDto(route);
        return routeDto;
    }

    @GetMapping
    public List<RouteDto> findAll() {
        List<Route> routes = routeService.findAll();
        List<RouteDto> routeDtoList = routeMapper.toDtoList(routes);
        return routeDtoList;
    }

    @PutMapping
    public RouteDto update(@RequestBody RouteDto routeDto) {
        Route route = routeMapper.fromDto(routeDto);
        Route updatedRoute = routeService.update(route);
        RouteDto routeDtoResult = routeMapper.toDto(updatedRoute);
        return routeDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        routeService.deleteById(id);
    }
}
