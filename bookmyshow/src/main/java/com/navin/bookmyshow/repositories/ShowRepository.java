package com.navin.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navin.bookmyshow.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Override
    Optional<Show> findById(Long id);

}
