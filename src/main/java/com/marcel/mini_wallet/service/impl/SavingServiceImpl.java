package com.marcel.mini_wallet.service.impl;

import com.marcel.mini_wallet.dto.SavingRequestDTO;
import com.marcel.mini_wallet.dto.SavingResponseDTO;
import com.marcel.mini_wallet.entity.Bank;
import com.marcel.mini_wallet.entity.Customer;
import com.marcel.mini_wallet.entity.Saving;
import com.marcel.mini_wallet.repository.BankRepository;
import com.marcel.mini_wallet.repository.CustomerRepository;
import com.marcel.mini_wallet.repository.SavingRepository;
import com.marcel.mini_wallet.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SavingServiceImpl implements SavingService {

    private final SavingRepository savingRepository;
    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SavingResponseDTO create(SavingRequestDTO request) {
        // 1. Validasi Customer
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // 2. Validasi Bank
        Bank bank = bankRepository.findById(request.getBankId())
                .orElseThrow(() -> new RuntimeException("Bank not found"));

        // 3. Generate Nomor Rekening Unik (Contoh sederhana: timestamp + random)
        String accountNumber = generateAccountNumber();

        // 4. Buat Entity Saving
        Saving saving = Saving.builder()
                .customer(customer)
                .bank(bank)
                .number(accountNumber)
                .label(request.getLabel())
                .amount(BigDecimal.ZERO) // Saldo awal 0
                .status(true)
                .build();

        savingRepository.save(saving);

        return mapToResponse(saving);
    }

    @Override
    @Transactional(readOnly = true)
    public SavingResponseDTO getById(String id) {
        Saving saving = savingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Saving account not found"));
        return mapToResponse(saving);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavingResponseDTO> getAll() {
        return savingRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SavingResponseDTO> getByCustomerId(String customerId) {
        return savingRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Helper: Generate Random Account Number (10 Digit)
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        // Digit pertama 1-9 biar gak nol di depan
        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private SavingResponseDTO mapToResponse(Saving saving) {
        return SavingResponseDTO.builder()
                .id(saving.getId())
                .number(saving.getNumber())
                .label(saving.getLabel())
                .amount(saving.getAmount())
                .status(saving.getStatus())
                // Ambil Nama Customer & Bank (Relasi JPA)
                .customerName(saving.getCustomer().getName())
                .bankName(saving.getBank().getName())
                .build();
    }
}