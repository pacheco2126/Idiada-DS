package com.idiada.exercise.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.idiada.exercise.domain.Vehicle;
import com.idiada.exercise.dto.CreateVehicleDTO;
import com.idiada.exercise.dto.VehicleDTO;
import com.idiada.exercise.services.VehicleService;
import com.idiada.exercise.web.converter.VehicleConverter;

@CrossOrigin(
		origins = "*", 
		allowCredentials = "true", 
		methods = {RequestMethod.GET, 
		           RequestMethod.POST, 
		           RequestMethod.PUT, 
		           RequestMethod.DELETE,
		           RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleConverter vehicleConverter;
	
	@GetMapping
    @ResponseBody
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.listAllVehicles();
        return vehicles.stream()
          .map(vehicleConverter::convertToDto)
          .collect(Collectors.toList());
    }
	
	@PostMapping
	@ResponseBody
	public VehicleDTO createVehicle(CreateVehicleDTO dto){
		Vehicle vehicle = vehicleService.createVehicle(vehicleConverter.convertToEntity(dto));
		return vehicleConverter.convertToDto(vehicle);
	}


}
