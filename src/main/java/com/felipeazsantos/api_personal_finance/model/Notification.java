package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    private User user;

    private NotificationType notificationType;

    private String message;

    private Instant sendDate;
}
