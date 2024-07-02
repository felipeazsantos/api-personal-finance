package com.felipeazsantos.api_personal_finance.controller.dto;

import com.felipeazsantos.api_personal_finance.model.BankAccount;
import com.felipeazsantos.api_personal_finance.model.Category;
import com.felipeazsantos.api_personal_finance.model.Entry;
import com.felipeazsantos.api_personal_finance.model.User;
import com.felipeazsantos.api_personal_finance.model.enums.EntryType;

import java.math.BigDecimal;
import java.time.Instant;

public record CreateEntryDto(Long bankAccountId,
                             EntryType entryType,
                             Long categoryId,
                             String description,
                             BigDecimal value,
                             String entryDate,
                             String checkingCopy) {

    public Entry toEntity(User user) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(bankAccountId);
        Instant date = Instant.parse(entryDate);
        Category category = new Category();
        category.setId(categoryId);
        return new Entry(user, bankAccount, entryType, category, description, value, date, checkingCopy);
    }
}
