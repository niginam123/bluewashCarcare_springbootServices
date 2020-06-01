package com.bluewash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluewash.entity.CarWasher;

@Repository
public interface CarWasherRepository extends JpaRepository<CarWasher, Long> {

}