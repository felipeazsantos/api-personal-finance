package com.felipeazsantos.api_personal_finance.repository;

import com.felipeazsantos.api_personal_finance.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
