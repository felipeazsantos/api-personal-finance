package com.felipeazsantos.api_personal_finance.controller.dto;

public record LoginResponse(String token, Long expiresIn) {
}
