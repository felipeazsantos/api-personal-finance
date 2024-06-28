package com.felipeazsantos.api_personal_finance.model;

import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

public class Base {

    @CreationTimestamp
    private Instant dateCreated;

    @CreationTimestamp
    private Instant dateUpdated;
}
