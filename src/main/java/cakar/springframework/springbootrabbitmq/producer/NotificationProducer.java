package cakar.springframework.springbootrabbitmq.producer;


import cakar.springframework.springbootrabbitmq.dtos.NotificationDTO;
import cakar.springframework.springbootrabbitmq.entities.Notification;
import cakar.springframework.springbootrabbitmq.jmsListener.NotificationListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String notifRoutingKey;

    @Qualifier("notifDirectExchange")
    private final DirectExchange notifExchange;

    public void sendToQueue(NotificationDTO notificationDTO){
       log.info("Sending message to queue");
       rabbitTemplate.convertAndSend(notifExchange.getName(), notifRoutingKey, notificationDTO);
    }
}
