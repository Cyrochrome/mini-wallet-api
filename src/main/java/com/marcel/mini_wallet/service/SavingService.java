package com.marcel.mini_wallet.service;

import com.marcel.mini_wallet.dto.SavingRequestDTO;
import com.marcel.mini_wallet.dto.SavingResponseDTO;

import java.util.List;

public interface SavingService {
    // Buka rekening baru
    SavingResponseDTO create(SavingRequestDTO request);

    // Ambil detail rekening by ID
    SavingResponseDTO getById(String id);

    // Ambil semua rekening
    List<SavingResponseDTO> getAll();

    // Ambil semua rekening milik Customer tertentu
    List<SavingResponseDTO> getByCustomerId(String customerId);
}