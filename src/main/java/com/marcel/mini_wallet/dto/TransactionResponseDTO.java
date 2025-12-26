package com.marcel.mini_wallet.dto;

import com.marcel.mini_wallet.entity.TransactionType;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseDTO {
    private String id;
    private BigDecimal amount;
    private TransactionType type;
    private String description;
    private LocalDateTime createdAt;

    // Info rekening terkait (opsional, tapi berguna)
    private String savingNumber;
}