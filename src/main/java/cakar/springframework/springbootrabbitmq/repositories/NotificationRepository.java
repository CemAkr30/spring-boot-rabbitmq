package cakar.springframework.springbootrabbitmq.repositories;

import cakar.springframework.springbootrabbitmq.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
