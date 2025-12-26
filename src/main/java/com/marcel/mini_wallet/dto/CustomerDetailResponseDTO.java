package com.marcel.mini_wallet.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder // Ganti @Builder jadi @SuperBuilder biar bisa inherit
@EqualsAndHashCode(callSuper = true)
public class CustomerDetailResponseDTO extends CustomerResponseDTO {
    // Ini tambahan khususnya: Daftar Rekening
    private List<SavingResponseDTO> savings;
}