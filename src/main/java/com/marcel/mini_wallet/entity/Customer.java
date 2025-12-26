package com.marcel.mini_wallet.entity;

import com.marcel.mini_wallet.util.GeneratedPrefixId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "customer")
@SQLDelete(sql = "UPDATE customer SET deleted_at = NOW() WHERE customer_id = ?")
@SQLRestriction("deleted_at IS NULL")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseEntity {

    @Id
    @GeneratedPrefixId("cst")
    @Column(name = "customer_id", length = 40)
    private String id;

    @Column(name = "customer_nik", nullable = false, unique = true, length = 16)
    private String nik;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private Boolean status = true;
}