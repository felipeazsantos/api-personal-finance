package com.felipeazsantos.api_personal_finance.model;

import com.felipeazsantos.api_personal_finance.model.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne
    private User user;

    private BankAccount bankAccount;

    private TransactionType transactionType;

    private Category category;

    private String description;

    private BigDecimal valor;

    private Instant transactionDate = Instant.now();

    private String checkingCopy;

}
