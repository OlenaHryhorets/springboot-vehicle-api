package com.myorg.controller;

import com.myorg.model.Vehicle;
import com.myorg.service.VehicleService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "api/v1/vehicle")
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping("")
  public List<Vehicle> getAllVehicles() {
    return vehicleService.getAllVehicles();
  }

  @GetMapping("/{id}")
  public Optional<Vehicle> getVehicleById(@PathVariable Integer id) {
    return vehicleService.getVehicleById(id);
  }

  @PostMapping("/save")
  public void saveVehicle(@RequestBody Vehicle vehicle) {
    vehicleService.saveVehicle(vehicle);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
    try {
      Optional<Vehicle> existVehicle = vehicleService.getVehicleById(id);
      vehicle.setId(id);
      vehicleService.saveVehicle(vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/{id}")
  public void deleteVehicleById(@PathVariable Integer id) {
    vehicleService.deleteVehicleById(id);
  }
}
