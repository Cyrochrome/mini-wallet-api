package com.marcel.mini_wallet.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavingResponseDTO {
    private String id;
    private String number; // Nomor rekening
    private String label;
    private BigDecimal amount;
    private Boolean status;

    // Info tambahan (Flattening) biar frontend gak perlu request 2x
    private String customerName;
    private String bankName;
}