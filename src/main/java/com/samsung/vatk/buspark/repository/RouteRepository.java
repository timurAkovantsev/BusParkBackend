package com.samsung.vatk.buspark.repository;


import com.samsung.vatk.buspark.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Route findByName(String name);
}
