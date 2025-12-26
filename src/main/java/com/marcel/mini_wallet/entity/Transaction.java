package com.marcel.mini_wallet.entity;

import com.marcel.mini_wallet.util.GeneratedPrefixId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "`transaction`") // Pakai backtick untuk keamanan keyword SQL
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedPrefixId("trx")
    @Column(name = "transaction_id", length = 40)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_id", nullable = false)
    private Saving saving;

    // SQL: transaction_amount decimal(20,2) unsigned
    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal amount;

    // SQL: transaction_type enum('DEPOSIT','WITHDRAW')
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType type;

    @Column(name = "transaction_description", nullable = false)
    private String description;

    // SQL: created_at timestamp default current_timestamp
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}