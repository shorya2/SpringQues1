package com.accolite.BookRentingApp.model;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;
    private boolean isReturned;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Rental() {}

    public Rental(LocalDateTime rentalStart, LocalDateTime rentalEnd, boolean isReturned, Book book, User user) {
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.isReturned = isReturned;
        this.book = book;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getRentalStart() { return rentalStart; }
    public void setRentalStart(LocalDateTime rentalStart) { this.rentalStart = rentalStart; }

    public LocalDateTime getRentalEnd() { return rentalEnd; }
    public void setRentalEnd(LocalDateTime rentalEnd) { this.rentalEnd = rentalEnd; }

    public boolean isReturned() { return isReturned; }
    public void setReturned(boolean returned) { isReturned = returned; }

    public Book getBook() {
        return book;
    }
    public void setBookId(Long bookId) { this.book.setId(bookId); }

    public User getUser() {
        return user;
    }
    public void setUserId(Long userId) {
        this.user.setId(userId);
    }
}

