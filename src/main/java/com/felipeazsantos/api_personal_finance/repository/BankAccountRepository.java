package com.felipeazsantos.api_personal_finance.repository;

import com.felipeazsantos.api_personal_finance.model.BankAccount;
import com.felipeazsantos.api_personal_finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findAllByUser(User user);
}
