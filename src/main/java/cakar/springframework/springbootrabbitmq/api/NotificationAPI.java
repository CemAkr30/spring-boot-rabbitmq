package cakar.springframework.springbootrabbitmq.api;


import cakar.springframework.springbootrabbitmq.dtos.NotificationDTO;
import cakar.springframework.springbootrabbitmq.entities.Notification;
import cakar.springframework.springbootrabbitmq.producer.NotificationProducer;
import cakar.springframework.springbootrabbitmq.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(NotificationAPI.BASE_URL)
@RequiredArgsConstructor
public class NotificationAPI {
    public static final String BASE_URL = "/api/notification";
    private final NotificationProducer notificationProducer;
    private final NotificationRepository notificationRepository;
    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notification){
         notificationProducer.sendToQueue(notification);
        return ResponseEntity.ok("Notification sent");
    }
    @GetMapping
    public ResponseEntity<String> getNotification(){
        return ResponseEntity.ok("Notification received");
    }
    @GetMapping("/getNotificationList")
    public ResponseEntity<List<Notification>> getNotificationList(){
        return ResponseEntity.ok(notificationRepository.findAll());
    }
}
