package com.accolite.BookRentingApp.Repository;


import com.accolite.BookRentingApp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Custom query method to find reviews by book ID
    List<Review> findByBookId(Long bookId);

    // Custom query method to find reviews by user ID
    List<Review> findByUserId(Long userId);
}

