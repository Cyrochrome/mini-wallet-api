package com.marcel.mini_wallet.entity;

import com.marcel.mini_wallet.util.GeneratedPrefixId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction; // <-- Pakai ini

import java.math.BigDecimal;

@Entity
@Table(name = "saving")
@SQLDelete(sql = "UPDATE saving SET deleted_at = NOW() WHERE saving_id = ?")
@SQLRestriction("deleted_at IS NULL") // <-- Ganti @Where jadi ini
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Saving extends BaseEntity {

    @Id
    @GeneratedPrefixId("sav")
    @Column(name = "saving_id", length = 40)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @Column(name = "saving_number", nullable = false, unique = true, length = 30)
    private String number;

    @Column(name = "saving_label", nullable = false)
    private String label;

    @Column(name = "saving_amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "saving_status", nullable = false)
    private Boolean status = true;
}