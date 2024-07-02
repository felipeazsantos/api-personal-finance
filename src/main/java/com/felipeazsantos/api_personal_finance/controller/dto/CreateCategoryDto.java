package com.felipeazsantos.api_personal_finance.controller.dto;

import com.felipeazsantos.api_personal_finance.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCategoryDto(@NotNull @NotBlank String name,
                                @NotNull @NotBlank String description) {

    public Category toEntity() {
        return new Category(name, description);
    }
}
