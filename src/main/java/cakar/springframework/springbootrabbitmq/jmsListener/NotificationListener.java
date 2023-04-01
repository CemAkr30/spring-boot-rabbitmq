package cakar.springframework.springbootrabbitmq.jmsListener;


import cakar.springframework.springbootrabbitmq.dtos.NotificationDTO;
import cakar.springframework.springbootrabbitmq.entities.Notification;
import cakar.springframework.springbootrabbitmq.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "notificationQueue")
    public void handleMessage(NotificationDTO notificationDTO)  {
        log.info("Message received: " + notificationDTO);
        try {
            Thread.sleep(10000);
            Notification notification = new Notification();
            notification.setMessage(notificationDTO.getMessage());
            notification.setStatus(notificationDTO.getStatus());
            notification.setType(notificationDTO.getType());
            log.info("Message processed: " + notification);
            notificationRepository.save(notification);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
