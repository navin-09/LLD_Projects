package com.navin.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navin.bookmyshow.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
     Optional<User> findById(Long id);

     Optional<User> findByEmail(String email);

     @Override
     User save(User entity);

}
