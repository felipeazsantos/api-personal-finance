package com.felipeazsantos.api_personal_finance.service;

import com.felipeazsantos.api_personal_finance.controller.dto.CreateBankAccountDto;
import com.felipeazsantos.api_personal_finance.model.BankAccount;
import com.felipeazsantos.api_personal_finance.model.User;
import com.felipeazsantos.api_personal_finance.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createBankAccount(CreateBankAccountDto dto, User user) {
        return bankAccountRepository.save(dto.toEntity(user));
    }

    public List<BankAccount> listBankAccounts(User user) {
        return bankAccountRepository.findAllByUser(user);
    }
}
