package com.bluewash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluewash.entity.CarWasher;
import com.bluewash.service.CarWasherService;

 @RestController
 public class CarWasherController {
	
	@Autowired
	CarWasherService carWasherService;
	
	@GetMapping("/carwashers")
	public ResponseEntity<List<CarWasher>> getCarWashers() {
        List<CarWasher> list = carWasherService.getAllCarWashers();
        return new ResponseEntity<List<CarWasher>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping("/createCarWasher")
	public ResponseEntity<CarWasher> creatStudent(@RequestBody CarWasher carWasher) {	  
	  CarWasher newCarWasher = carWasherService.createCarWasher(carWasher);
	  return new ResponseEntity<CarWasher>(newCarWasher, HttpStatus.CREATED);		        
    }
	
	@PutMapping("/updateCarWasher")
	public ResponseEntity<CarWasher> updateStudent(@RequestBody CarWasher carWasher) {
		Optional<CarWasher> availableCarWasher = carWasherService.getCarWasherById(carWasher.getId());
		CarWasher newCarWasher = null;
		if(availableCarWasher.isPresent()) {
			CarWasher washer = availableCarWasher.get();
			washer.setName(carWasher.getName());
			washer.setBranch(carWasher.getBranch());
			washer.setStatus(carWasher.getStatus());
			washer = carWasherService.updateCarWasher(washer);
			return new ResponseEntity<CarWasher>(washer,HttpStatus.OK);
		} else {
			newCarWasher = carWasherService.createCarWasher(carWasher);
			return new ResponseEntity<CarWasher>(newCarWasher,HttpStatus.CREATED);
		}        
    }
	
	@GetMapping("/carwasher/{id}")
	public Optional<CarWasher> getCarWasher(@PathVariable("id") Long id) {
      return carWasherService.getCarWasherById(id);
    }
	
	@DeleteMapping("/deleteCarWasher/{id}")
	public String deleteCarWasher(@PathVariable("id") Long id) {
	  carWasherService.deleteCarWasherById(id);
      return "Successfully Deleted CarWasher";
    }
	
	@DeleteMapping("/deleteCarWasher")
	public String deleteCarWasher(@RequestBody CarWasher carWasher) {
	  carWasherService.deleteCarWasher(carWasher);
      return "Successfully Deleted CarWasher!";
    }

}

