package com.felipeazsantos.api_personal_finance.model;

import com.felipeazsantos.api_personal_finance.model.enums.EntryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_entry")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Entry extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    private EntryType entryType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String description;

    private BigDecimal value = BigDecimal.ZERO;

    @CreationTimestamp
    private Instant entryDate;

    private String checkingCopy;

    public Entry(User user, BankAccount bankAccount, EntryType entryType, Category category, String description, BigDecimal value, Instant entryDate, String checkingCopy) {
        this.user = user;
        this.bankAccount = bankAccount;
        this.entryType = entryType;
        this.category = category;
        this.description = description;
        this.value = value;
        this.entryDate = entryDate;
        this.checkingCopy = checkingCopy;
    }
}
