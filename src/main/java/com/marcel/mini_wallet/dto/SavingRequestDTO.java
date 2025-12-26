package com.marcel.mini_wallet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavingRequestDTO {

    @NotBlank(message = "Customer ID wajib diisi")
    private String customerId;

    @NotBlank(message = "Bank ID wajib diisi")
    private String bankId;

    @NotBlank(message = "Label tabungan wajib diisi (misal: Tabungan Utama)")
    private String label;
}