package com.felipeazsantos.api_personal_finance.repository;

import com.felipeazsantos.api_personal_finance.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
