package cakar.springframework.springbootrabbitmq.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification implements Serializable {
    // rabbitMQ için gerekli olan alanlar burada tanımlanıyor. -> implements Serializable
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
//    @Column(name = "created_date")
//    @CreationTimestamp
//    private LocalDateTime createdDate;
//    @Column(name = "updated_date")
//    @UpdateTimestamp
//    private LocalDateTime updatedDate;
}
