package com.marcel.mini_wallet.entity;

import com.marcel.mini_wallet.util.GeneratedPrefixId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {

    @Id
    @GeneratedPrefixId("bnk")
    @Column(name = "bank_id", length = 40)
    private String id;

    @Column(name = "bank_name", nullable = false)
    private String name;

    @Column(name = "bank_code", nullable = false, length = 10)
    private String code;
}