package com.felipeazsantos.api_personal_finance.repository;

import com.felipeazsantos.api_personal_finance.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
