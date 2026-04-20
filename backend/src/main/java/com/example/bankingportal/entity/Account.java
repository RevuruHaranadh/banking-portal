package com.example.bankingportal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    private String accountType;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL)
    private List<Transaction> outgoingTransactions;
}