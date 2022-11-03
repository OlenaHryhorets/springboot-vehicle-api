package com.myorg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
  private int id;
  private String title;
  private String model;
  private String type;
  private int millage;
  private String color;
  private String registrationCountry;


  public Vehicle() {
  }

  public Vehicle(int id, String title, String model, String type, int millage,
                 String color, String registrationCountry) {
    this.id = id;
    this.title = title;
    this.model = model;
    this.type = type;
    this.millage = millage;
    this.color = color;
    this.registrationCountry = registrationCountry;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getMillage() {
    return millage;
  }

  public void setMillage(int millage) {
    this.millage = millage;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegistrationCountry() {
    return registrationCountry;
  }

  public void setRegistrationCountry(String registrationCountry) {
    this.registrationCountry = registrationCountry;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

}
