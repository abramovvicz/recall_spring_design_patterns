package com.abramovvicz.notifiaction;

import com.abramovvicz.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/notification/")
public record NotificationController(NotificationService notificationService) {


    @PostMapping
    void saveNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.registerNotification(notificationRequest);
    }

}
