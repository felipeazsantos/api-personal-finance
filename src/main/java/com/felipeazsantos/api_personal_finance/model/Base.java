package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Setter
@Getter
public class Base {
    @CreationTimestamp
    private Instant dateCreated;

    @CreationTimestamp
    private Instant dateUpdated;
}
