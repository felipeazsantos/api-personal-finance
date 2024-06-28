package com.felipeazsantos.api_personal_finance.config;

import com.felipeazsantos.api_personal_finance.model.Role;
import com.felipeazsantos.api_personal_finance.model.User;
import com.felipeazsantos.api_personal_finance.repository.RoleRepository;
import com.felipeazsantos.api_personal_finance.repository.UserRepositoty;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepositoty userRepositoty;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepositoty userRepositoty,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepositoty = userRepositoty;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = userRepositoty.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> { System.out.println("admin já existe"); } ,
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("admin"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepositoty.save(user);
                }
        );
    }
}
