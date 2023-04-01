package cakar.springframework.springbootrabbitmq.configurations;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String notifQueue;

    @Value("${spring.rabbitmq.template.exchange}")
    private String notifExchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String notifRoutingKey;

    @Bean
    public DirectExchange notifDirectExchange(){
        return new DirectExchange(notifExchange);
    }
    @Bean
    public Queue notifQueue(){
        return new Queue(notifQueue);
    }
    @Bean
    public Binding notifBinding(final Queue notifQueue, final DirectExchange notifDirectExchange) {
       return BindingBuilder.bind(notifQueue).to(notifDirectExchange).with(notifRoutingKey);
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("localhost");
        connectionFactory.setUsername("cakar");
        connectionFactory.setPassword("1905");
        return connectionFactory;
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
