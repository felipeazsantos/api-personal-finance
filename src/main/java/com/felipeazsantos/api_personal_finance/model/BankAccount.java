package com.felipeazsantos.api_personal_finance.model;

import com.felipeazsantos.api_personal_finance.model.enums.BankAccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_bank_account")
@Data
@AllArgsConstructor
public class BankAccount extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private BigDecimal balance;
    private BankAccountType accountType;

    public BankAccount(User user, String name, BigDecimal balance, BankAccountType accountType) {
        this.user = user;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }
}
