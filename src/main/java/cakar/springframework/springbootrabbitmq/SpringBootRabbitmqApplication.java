package cakar.springframework.springbootrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

}
