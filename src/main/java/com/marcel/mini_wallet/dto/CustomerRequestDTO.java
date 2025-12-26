package com.marcel.mini_wallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomerRequestDTO {

    @NotBlank(message = "Nama wajib diisi")
    private String name;

    @NotBlank(message = "NIK wajib diisi")
    @Size(min = 16, max = 16, message = "NIK harus 16 karakter")
    private String nik;
}