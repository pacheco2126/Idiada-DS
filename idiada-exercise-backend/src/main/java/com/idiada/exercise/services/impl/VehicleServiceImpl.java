package com.idiada.exercise.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idiada.exercise.domain.Vehicle;
import com.idiada.exercise.persistence.repository.VehicleRepository;
import com.idiada.exercise.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> listAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void createVehicles(List<Vehicle> vehicles) {
		vehicleRepository.saveAll(vehicles);
	}


}
