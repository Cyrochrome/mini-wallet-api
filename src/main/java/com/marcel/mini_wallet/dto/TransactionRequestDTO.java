package com.marcel.mini_wallet.dto;

import com.marcel.mini_wallet.entity.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequestDTO {

    @NotBlank(message = "Saving ID (Rekening) wajib diisi")
    private String savingId;

    @NotNull(message = "Jumlah uang wajib diisi")
    @Min(value = 1, message = "Jumlah transaksi minimal 1")
    private BigDecimal amount;

    @NotNull(message = "Tipe transaksi wajib diisi (DEPOSIT / WITHDRAW)")
    private TransactionType type;

    @NotBlank(message = "Deskripsi wajib diisi")
    private String description;
}