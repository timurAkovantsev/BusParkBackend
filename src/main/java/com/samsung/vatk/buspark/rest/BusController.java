package com.samsung.vatk.buspark.rest;

import com.samsung.vatk.buspark.domain.Bus;
import com.samsung.vatk.buspark.domain.dto.BusDto;
import com.samsung.vatk.buspark.domain.mapper.BusMapper;
import com.samsung.vatk.buspark.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

    private BusService busService;
    private BusMapper busMapper;

    public BusController(BusService busService, BusMapper busMapper) {
        this.busService = busService;
        this.busMapper = busMapper;
    }


    @PostMapping
    public BusDto create(@RequestParam String busName,
                         @RequestParam String routeName,
                         @RequestParam String driverName) {

        Bus createdBus = busService.create(busName, routeName, driverName);
        BusDto busDtoResult = busMapper.toDto(createdBus);
        return busDtoResult;
    }

    @PostMapping("/{id}")
    public BusDto updateBusById(
            @PathVariable Long id,
            @RequestParam String newBusName,
            @RequestParam String newRouteName,
            @RequestParam String newDriverName
    ) {

        Bus updatedBus = busService.update(
                id,
                newBusName,
                newRouteName,
                newDriverName
        );

        BusDto busDtoResult = busMapper.toDto(updatedBus);
        return busDtoResult;
    }

    @GetMapping("/{id}")
    public BusDto findById(@PathVariable("id") Long id) {
        Bus bus = busService.findById(id);
        BusDto busDto = busMapper.toDto(bus);
        return busDto;
    }

    @GetMapping
    public List<BusDto> findAll() {
        List<Bus> buss = busService.findAll();
        List<BusDto> busDtoList = busMapper.toDtoList(buss);
        return busDtoList;
    }

    @PutMapping
    public BusDto update(@RequestBody BusDto busDto) {
        Bus bus = busMapper.fromDto(busDto);
        Bus updatedBus = busService.update(bus);
        BusDto busDtoResult = busMapper.toDto(updatedBus);
        return busDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        busService.deleteById(id);
    }
}
