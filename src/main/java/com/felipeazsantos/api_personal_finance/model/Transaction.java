package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_transaction")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction extends Base {

    private User user;

    private BankAccount bankAccount;

    private TransactionType transactionType;

    private Category category;

    private String description;

    private BigDecimal valor;

    private Instant transactionDate = Instant.now();

    private String checkingCopy;

}
