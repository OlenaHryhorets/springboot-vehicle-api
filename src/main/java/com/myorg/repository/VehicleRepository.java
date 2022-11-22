package com.myorg.repository;

import com.myorg.model.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
  List<Vehicle> findVehiclesByUserId(int userId);
}
