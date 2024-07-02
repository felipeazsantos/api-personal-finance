package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Entry> entries;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Budget> budgets;
}
