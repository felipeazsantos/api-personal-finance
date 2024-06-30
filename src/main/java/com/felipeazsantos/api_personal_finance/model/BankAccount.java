package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_bank_account")
public class BankAccount extends Base {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private BigDecimal startBalance;
    private BigDecimal currentBalance;

    private BankAccountType accountType;


}
