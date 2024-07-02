package com.felipeazsantos.api_personal_finance.controller;

import com.felipeazsantos.api_personal_finance.controller.dto.CreateBankAccountDto;
import com.felipeazsantos.api_personal_finance.model.BankAccount;
import com.felipeazsantos.api_personal_finance.service.BankAccountService;
import com.felipeazsantos.api_personal_finance.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final UserService userService;

    public BankAccountController(BankAccountService bankAccountService, UserService userService) {
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    @GetMapping("/bank-accounts")
    public ResponseEntity<List<BankAccount>> listBankAccounts(JwtAuthenticationToken token) {
        var user = userService.retrieveUserFromJwtToken(token);
        var bankAccount = bankAccountService.listBankAccounts(user);
        return ResponseEntity.ok(bankAccount);
    }


    @PostMapping("/bank-accounts")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody CreateBankAccountDto dto, JwtAuthenticationToken token) {
        var user = userService.retrieveUserFromJwtToken(token);
        var bankAccount = bankAccountService.createBankAccount(dto, user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(bankAccount.getId())
                .toUri();

        return ResponseEntity.created(location).body(bankAccount);
    }
}
