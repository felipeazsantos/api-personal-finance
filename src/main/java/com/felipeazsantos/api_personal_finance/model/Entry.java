package com.felipeazsantos.api_personal_finance.model;

import com.felipeazsantos.api_personal_finance.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_entry")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Entry extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String description;

    private BigDecimal valor;

    private Instant transactionDate = Instant.now();

    private String checkingCopy;

}
