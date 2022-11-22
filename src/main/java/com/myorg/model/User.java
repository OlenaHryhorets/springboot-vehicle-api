package com.myorg.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  private int id;
  private String firstName;
  private String lastName;
  private String username;

//  @OneToMany(mappedBy = "user")
//  private List<Vehicle> userCars;
}
