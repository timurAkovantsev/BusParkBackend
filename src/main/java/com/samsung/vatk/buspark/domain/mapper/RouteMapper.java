package com.samsung.vatk.buspark.domain.mapper;

import com.samsung.vatk.buspark.domain.Route;
import com.samsung.vatk.buspark.domain.dto.RouteDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteMapper {

    public Route fromDto(RouteDto routeDto) {
        Route route = new Route();
        route.setId(routeDto.getId());
        route.setName(routeDto.getName());
        return route;
    }

    public RouteDto toDto(Route route) {
        RouteDto routeDto = new RouteDto();
        routeDto.setId(route.getId());
        routeDto.setName(route.getName());
        return routeDto;
    }

    public List<RouteDto> toDtoList(List<Route> routeList) {
        List<RouteDto> routeDtoList = new ArrayList<>();
        for (Route route :
                routeList) {
            routeDtoList.add(toDto(route));
        }
        return routeDtoList;
    }
}
