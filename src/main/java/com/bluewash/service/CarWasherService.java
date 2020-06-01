package com.bluewash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluewash.entity.CarWasher;
import com.bluewash.repository.CarWasherRepository;

  @Service
  public class CarWasherService {
	
	@Autowired
	CarWasherRepository carWasherRepository;
	
	public List<CarWasher> getAllCarWashers() {
	 List<CarWasher> carWashers = new ArrayList<CarWasher>();
	 carWasherRepository.findAll().forEach(carWasher -> carWashers.add(carWasher));
	 return carWashers;
	}
	
	public CarWasher createCarWasher(CarWasher carWasher) {
	 return carWasherRepository.save(carWasher);
	}
	
	public Optional<CarWasher> getCarWasherById(Long id) {
	 return carWasherRepository.findById(id);		
	}
	
	public CarWasher updateCarWasher(CarWasher carWasher) {
	 return carWasherRepository.save(carWasher);
	}

	public void deleteCarWasherById(Long id) {
		carWasherRepository.deleteById(id);
	}
	
	public void deleteCarWasher(CarWasher carWasher) {
		carWasherRepository.delete(carWasher);
	}
	
}

