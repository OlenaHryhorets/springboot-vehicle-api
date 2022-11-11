package com.myorg.service;

import com.myorg.model.User;
import com.myorg.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Integer id) {
    return userRepository.findById(id);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUserById(Integer id) {
    userRepository.deleteById(id);
  }
}
