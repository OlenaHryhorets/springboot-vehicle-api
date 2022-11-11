package com.myorg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {
  @Id
  private int id;
  private String title;
  private String model;
  private String type;
  private int millage;
  private String color;
  private String registrationCountry;
}
