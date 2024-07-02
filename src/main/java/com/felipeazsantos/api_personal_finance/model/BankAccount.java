package com.felipeazsantos.api_personal_finance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipeazsantos.api_personal_finance.model.enums.BankAccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_bank_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankAccount extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
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
