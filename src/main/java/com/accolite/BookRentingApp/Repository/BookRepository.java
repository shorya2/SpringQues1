package com.accolite.BookRentingApp.Repository;



import com.accolite.BookRentingApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query method to search books by genre
    List<Book> findByGenre(String genre);

    // Custom query method to search books by title
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Custom query method to search books by both genre and title
    List<Book> findByGenreAndTitleContainingIgnoreCase(String genre, String title);
}

