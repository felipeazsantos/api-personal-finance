package com.felipeazsantos.api_personal_finance.controller;

import com.felipeazsantos.api_personal_finance.controller.dto.CreateCategoryDto;
import com.felipeazsantos.api_personal_finance.model.Category;
import com.felipeazsantos.api_personal_finance.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listCategories() {
        var categories = categoryService.listCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> createCategory(@RequestBody @Valid CreateCategoryDto dto) {
        var category = categoryService.createCategory(dto.toEntity());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
