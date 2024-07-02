package com.felipeazsantos.api_personal_finance.model;

import com.felipeazsantos.api_personal_finance.model.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_notification")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Notification extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private NotificationType notificationType;

    private String message;

    private Instant sendDate;
}
