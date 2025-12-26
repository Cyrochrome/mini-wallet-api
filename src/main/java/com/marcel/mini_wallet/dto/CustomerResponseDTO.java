package com.marcel.mini_wallet.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CustomerResponseDTO {
    private String id;
    private String name;
    private String nik;
    private Boolean status;
    private LocalDateTime createdAt;
}