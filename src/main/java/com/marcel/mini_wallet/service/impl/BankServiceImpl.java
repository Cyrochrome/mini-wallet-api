package com.marcel.mini_wallet.service.impl;

import com.marcel.mini_wallet.dto.BankRequestDTO;
import com.marcel.mini_wallet.dto.BankResponseDTO;
import com.marcel.mini_wallet.entity.Bank;
import com.marcel.mini_wallet.repository.BankRepository;
import com.marcel.mini_wallet.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // Wajib: Menandakan ini adalah Bean Service (Koki)
@RequiredArgsConstructor // Lombok otomatis buatkan constructor untuk Injection
public class BankServiceImpl implements BankService {

    // Inject Repository (Gudang)
    private final BankRepository bankRepository;

    @Override
    @Transactional(rollbackFor = Exception.class) // Jika error, batalkan semua perubahan DB
    public BankResponseDTO create(BankRequestDTO request) {
        // 1. Konversi DTO -> Entity (Bahan -> Masakan)
        Bank bank = Bank.builder()
                .name(request.getName())
                .code(request.getCode())
                .build();

        // 2. Simpan ke DB
        bankRepository.save(bank);

        // 3. Kembalikan Response (Piring Saji)
        return mapToResponse(bank);
    }

    @Override
    @Transactional(readOnly = true) // Cuma baca, lebih cepat performance-nya
    public List<BankResponseDTO> getAll() {
        return bankRepository.findAll().stream()
                .map(this::mapToResponse) // Convert tiap Entity jadi DTO
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BankResponseDTO getById(String id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found with id: " + id));

        return mapToResponse(bank);
    }

    // Helper method biar gak nulis ulang-ulang mappingnya
    private BankResponseDTO mapToResponse(Bank bank) {
        return BankResponseDTO.builder()
                .id(bank.getId())
                .name(bank.getName())
                .code(bank.getCode())
                .build();
    }
}