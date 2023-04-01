package cakar.springframework.springbootrabbitmq.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements Serializable {

    private String message;
    private String type;
    private String status;
}
