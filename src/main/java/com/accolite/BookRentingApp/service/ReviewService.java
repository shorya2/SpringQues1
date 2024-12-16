package com.accolite.BookRentingApp.service;


import com.accolite.BookRentingApp.model.Review;
import com.accolite.BookRentingApp.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Method to add a new review
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    // Method to update an existing review
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    // Method to find reviews by book ID
    public List<Review> getReviewsByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Method to find reviews by user ID
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}
