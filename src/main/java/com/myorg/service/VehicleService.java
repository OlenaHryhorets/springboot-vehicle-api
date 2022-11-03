package com.myorg.service;

import com.myorg.model.Vehicle;
import com.myorg.repository.VehicleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleService {
  private final VehicleRepository vehicleRepository;

  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  public List<Vehicle> getAllVehicles() {
    return vehicleRepository.findAll();
  }

  public Optional<Vehicle> getVehicleById(Integer id) {
    return vehicleRepository.findById(id);
  }

  public Vehicle saveVehicle(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  public void deleteVehicleById(Integer id) {
    vehicleRepository.deleteById(id);
  }
}
