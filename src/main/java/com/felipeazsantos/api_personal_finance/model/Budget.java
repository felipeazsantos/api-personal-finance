package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_budget")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Budget extends Base {

    private User user;

    private Category category;

    private Instant beginDate;

    private Instant endDate;
}