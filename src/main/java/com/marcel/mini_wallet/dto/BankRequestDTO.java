package com.marcel.mini_wallet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankRequestDTO {

    @NotBlank(message = "Nama bank tidak boleh kosong")
    private String name;

    @NotBlank(message = "Kode bank tidak boleh kosong")
    private String code;
}