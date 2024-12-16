package com.accolite.BookRentingApp.service;


import com.accolite.BookRentingApp.model.Rental;
import com.accolite.BookRentingApp.Repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // Method to rent a book
    public Rental rentBook(Long bookId, Long userId) {
        Rental rental = new Rental();
        rental.setBookId(bookId);
        rental.setUserId(userId);
        rental.setRentalStart(LocalDateTime.now());
        rental.setRentalEnd(LocalDateTime.now().plusWeeks(1));
        rental.setReturned(false);
        return rentalRepository.save(rental);
    }

    // Method to extend the rental period
    public Optional<Rental> extendRental(Long rentalId, LocalDateTime newEndDate) {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isPresent()) {
            Rental rental = rentalOptional.get();
            rental.setRentalEnd(newEndDate);
            return Optional.of(rentalRepository.save(rental));
        }
        return Optional.empty();
    }

    // Method to return a rented book
    public Optional<Rental> returnBook(Long rentalId) {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isPresent()) {
            Rental rental = rentalOptional.get();
            rental.setReturned(true);
            return Optional.of(rentalRepository.save(rental));
        }
        return Optional.empty();
    }

    public List<Rental> getRentalsByUserId(Long userId) {
        return rentalRepository.findByUser(userId);
    }
}

