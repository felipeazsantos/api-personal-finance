package com.felipeazsantos.api_personal_finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category extends Base {

    private String name;
    private String description;
}
