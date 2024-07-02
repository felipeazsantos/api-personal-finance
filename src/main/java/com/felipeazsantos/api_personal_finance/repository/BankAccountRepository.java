package com.felipeazsantos.api_personal_finance.repository;

import com.felipeazsantos.api_personal_finance.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
