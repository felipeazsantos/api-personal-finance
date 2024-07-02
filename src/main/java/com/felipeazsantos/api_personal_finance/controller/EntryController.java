package com.felipeazsantos.api_personal_finance.controller;

import com.felipeazsantos.api_personal_finance.controller.dto.CreateEntryDto;
import com.felipeazsantos.api_personal_finance.model.Entry;
import com.felipeazsantos.api_personal_finance.service.EntryService;
import com.felipeazsantos.api_personal_finance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EntryController {
    private final UserService userService;
    private final EntryService entryService;

    public EntryController(UserService userService, EntryService entryService) {
        this.userService = userService;
        this.entryService = entryService;
    }

    @PostMapping("/entries")
    public ResponseEntity<Entry> createEntry(@RequestBody CreateEntryDto dto, JwtAuthenticationToken token) {
        var user = userService.retrieveUserFromJwtToken(token);
        var entry = entryService.createEntry(dto.toEntity(user));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(entry.getId())
                .toUri();

        return ResponseEntity.created(location).body(entry);
    }

}
