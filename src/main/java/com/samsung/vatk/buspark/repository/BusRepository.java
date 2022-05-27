package com.samsung.vatk.buspark.repository;


import com.samsung.vatk.buspark.domain.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
