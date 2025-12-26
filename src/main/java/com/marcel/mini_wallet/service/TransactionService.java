package com.marcel.mini_wallet.service;

import com.marcel.mini_wallet.dto.TransactionRequestDTO;
import com.marcel.mini_wallet.dto.TransactionResponseDTO;
import java.util.List;

public interface TransactionService {
    // Satu pintu untuk Deposit maupun Withdraw
    TransactionResponseDTO create(TransactionRequestDTO request);

    // Lihat riwayat mutasi rekening tertentu
    List<TransactionResponseDTO> getAllBySavingId(String savingId);
}