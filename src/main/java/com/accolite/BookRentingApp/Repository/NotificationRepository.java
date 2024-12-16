package com.accolite.BookRentingApp.Repository;


import com.accolite.BookRentingApp.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Custom query method to find notifications by user ID
    List<Notification> findByUserId(Long userId);

    // Custom query method to find notifications by read status
    List<Notification> findByIsRead(boolean isRead);
}

