package com.abramovvicz.notifiaction;

import com.abramovvicz.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
record NotificationService(NotificationRepository notificationRepository) {

    void registerNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                                                .toCustomerId(notificationRequest.toCustomerId())
                                                .toCustomerEmail(notificationRequest.toCustomerName())
                                                .sender("abramovvicz")
                                                .message(notificationRequest.message())
                                                .sentAt(LocalDateTime.now())
                                                .build();
    }
}
