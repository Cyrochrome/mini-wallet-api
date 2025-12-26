package com.marcel.mini_wallet.service.impl;

import com.marcel.mini_wallet.dto.TransactionRequestDTO;
import com.marcel.mini_wallet.dto.TransactionResponseDTO;
import com.marcel.mini_wallet.entity.Saving;
import com.marcel.mini_wallet.entity.Transaction;
import com.marcel.mini_wallet.entity.TransactionType;
import com.marcel.mini_wallet.repository.SavingRepository;
import com.marcel.mini_wallet.repository.TransactionRepository;
import com.marcel.mini_wallet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final SavingRepository savingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class) // PENTING: Data konsisten atau batal sama sekali
    public TransactionResponseDTO create(TransactionRequestDTO request) {
        // 1. Cari Rekening (Saving)
        Saving saving = savingRepository.findById(request.getSavingId())
                .orElseThrow(() -> new RuntimeException("Saving account not found"));

        // 2. Validasi & Hitung Saldo Baru
        BigDecimal currentBalance = saving.getAmount();
        BigDecimal transactionAmount = request.getAmount();

        if (request.getType() == TransactionType.WITHDRAW) {
            // Cek saldo cukup gak?
            if (currentBalance.compareTo(transactionAmount) < 0) {
                throw new RuntimeException("Insufficient balance (Saldo tidak cukup)");
            }
            // Kurangi saldo
            saving.setAmount(currentBalance.subtract(transactionAmount));
        } else if (request.getType() == TransactionType.DEPOSIT) {
            // Tambah saldo
            saving.setAmount(currentBalance.add(transactionAmount));
        }

        // 3. Update Saldo di Tabel Saving
        savingRepository.save(saving);

        // 4. Catat Riwayat di Tabel Transaction
        Transaction transaction = Transaction.builder()
                .saving(saving)
                .amount(transactionAmount)
                .type(request.getType())
                .description(request.getDescription())
                .build();

        transactionRepository.save(transaction);

        // 5. Return DTO
        return mapToResponse(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionResponseDTO> getAllBySavingId(String savingId) {
        // Pastikan rekeningnya ada dulu
        if (!savingRepository.existsById(savingId)) {
            throw new RuntimeException("Saving account not found");
        }

        return transactionRepository.findBySavingIdOrderByCreatedAtDesc(savingId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private TransactionResponseDTO mapToResponse(Transaction trx) {
        return TransactionResponseDTO.builder()
                .id(trx.getId())
                .amount(trx.getAmount())
                .type(trx.getType())
                .description(trx.getDescription())
                .createdAt(trx.getCreatedAt())
                .savingNumber(trx.getSaving().getNumber()) // Info tambahan
                .build();
    }
}