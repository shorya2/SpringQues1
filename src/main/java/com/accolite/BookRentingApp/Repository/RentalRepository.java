package com.accolite.BookRentingApp.Repository;


import com.accolite.BookRentingApp.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    // Custom query method to find rentals by user ID
    List<Rental> findByUser(Long userId);
}

