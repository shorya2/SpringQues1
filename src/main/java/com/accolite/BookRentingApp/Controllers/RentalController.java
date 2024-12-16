package com.accolite.BookRentingApp.Controllers;

import com.accolite.BookRentingApp.model.Rental;
import com.accolite.BookRentingApp.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    // Get all rentals for a specific user
    @GetMapping("/user/{userId}")
    public List<Rental> getUserRentals(@PathVariable Long userId) {
        return rentalService.getRentalsByUserId(userId);
    }

    // Rent a book
    @PostMapping("/rent")
    public Rental rentBook(@RequestParam Long bookId, @RequestParam Long userId) {

        return rentalService.rentBook(bookId,userId);
    }

    // Return a rented book
    @PostMapping("/return/{rentalId}")
    public ResponseEntity<Rental> returnBook(@PathVariable Long rentalId) {
        return rentalService.returnBook(rentalId)
                .map(rental -> ResponseEntity.ok().body(rental))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Extend rental period
    @PostMapping("/extend/{rentalId}")
    public ResponseEntity<Rental> extendRental(@PathVariable Long rentalId,@RequestParam String newEndDate) {
        LocalDateTime parsedDate = LocalDateTime.parse(newEndDate);
        return rentalService.extendRental(rentalId,parsedDate)
                .map(rental -> ResponseEntity.ok().body(rental))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
