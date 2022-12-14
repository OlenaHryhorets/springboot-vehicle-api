package com.myorg.controller;

import com.myorg.model.Vehicle;
import com.myorg.service.UserService;
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
import org.webjars.NotFoundException;

@RestController
@RequestMapping(value =  "api/v1/vehicle")
public class VehicleController {

  private final VehicleService vehicleService;
  private final UserService userService;

  public VehicleController(VehicleService vehicleService, UserService userService) {
    this.vehicleService = vehicleService;
    this.userService = userService;
  }

  @GetMapping("")
  public List<Vehicle> getAllVehicles() {
    return vehicleService.getAllVehicles();
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<Vehicle>> getAllVehiclesByUserId(@PathVariable(value = "id") int userId) {
    if (!userService.existsById(userId)) {
      throw new NotFoundException("Not found user with id = " + userId);
    }
    List<Vehicle> userCars = vehicleService.getAllVehiclesByUserId(userId);
    return new ResponseEntity<>(userCars, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Optional<Vehicle> getVehicleById(@PathVariable Integer id) {
    return vehicleService.getVehicleById(id);
  }

  @PostMapping("")
  public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) {
    ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.CREATED);
    try {
      vehicleService.saveVehicle(vehicle);
      return response;
    } catch (Exception e) {
      response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      return response;
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
    ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
    try {
      Optional<Vehicle> existVehicle = vehicleService.getVehicleById(id);
      vehicle.setId(id);
      vehicleService.saveVehicle(vehicle);
      return response;
    } catch (NoSuchElementException e) {
      response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
      return response;
    }
  }

  @DeleteMapping("/{id}")
  public void deleteVehicleById(@PathVariable Integer id) {
    vehicleService.deleteVehicleById(id);
  }
}
