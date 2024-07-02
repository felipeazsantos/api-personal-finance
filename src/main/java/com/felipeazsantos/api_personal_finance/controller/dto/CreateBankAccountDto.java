package com.felipeazsantos.api_personal_finance.controller.dto;

import com.felipeazsantos.api_personal_finance.model.BankAccount;
import com.felipeazsantos.api_personal_finance.model.enums.BankAccountType;
import com.felipeazsantos.api_personal_finance.model.User;

import java.math.BigDecimal;

public record CreateBankAccountDto(String name,
                                   BigDecimal balance,
                                   BankAccountType accountType
) {

    public BankAccount toEntity(User user) {
        return new BankAccount(user, name, balance, accountType);
    }
}
