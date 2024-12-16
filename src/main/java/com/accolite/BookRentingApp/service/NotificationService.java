package com.accolite.BookRentingApp.service;


import com.accolite.BookRentingApp.model.Notification;
import com.accolite.BookRentingApp.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Method to send a new notification
    public Notification sendNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Method to fetch notifications by user ID
    public List<Notification> getNotificationsByUser(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Method to fetch notifications by read status
    public List<Notification> getNotificationsByReadStatus(boolean isRead) {
        return notificationRepository.findByIsRead(isRead);
    }

    // Method to mark a notification as read
    public Notification markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId).orElse(null);
        if (notification != null) {
            notification.setRead(true);
            return notificationRepository.save(notification);
        }
        return null;
    }
}

