package com.marcel.mini_wallet.service;

import com.marcel.mini_wallet.dto.BankRequestDTO;
import com.marcel.mini_wallet.dto.BankResponseDTO;

import java.util.List;

public interface BankService {
    // Fitur 1: Buat Bank Baru
    BankResponseDTO create(BankRequestDTO request);

    // Fitur 2: Ambil semua data bank
    List<BankResponseDTO> getAll();

    // Fitur 3: Ambil satu bank by ID (untuk detail)
    BankResponseDTO getById(String id);
}