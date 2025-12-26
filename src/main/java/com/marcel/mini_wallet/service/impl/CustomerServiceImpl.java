package com.marcel.mini_wallet.service.impl;

import com.marcel.mini_wallet.dto.*;
import com.marcel.mini_wallet.entity.Customer;
import com.marcel.mini_wallet.entity.Saving;
import com.marcel.mini_wallet.repository.CustomerRepository;
import com.marcel.mini_wallet.repository.SavingRepository;
import com.marcel.mini_wallet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final SavingRepository savingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CustomerResponseDTO create(CustomerRequestDTO request) {
        if (customerRepository.existsByNik(request.getNik())) {
            throw new RuntimeException("NIK already registered");
        }

        Customer customer = Customer.builder()
                .name(request.getName())
                .nik(request.getNik())
                .status(true)
                .build();

        customerRepository.save(customer);
        return mapToResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDetailResponseDTO getDetailByNik(String nik) {
        // 1. Cari Customer
        Customer customer = customerRepository.findByNik(nik)
                .orElseThrow(() -> new RuntimeException("Customer not found with NIK: " + nik));

        // 2. Cari Savings
        List<Saving> savings = savingRepository.findByCustomerId(customer.getId());

        // 3. Convert Savings to DTO
        List<SavingResponseDTO> savingDTOs = savings.stream()
                .map(saving -> SavingResponseDTO.builder()
                        .id(saving.getId())
                        .number(saving.getNumber())
                        .label(saving.getLabel())
                        .amount(saving.getAmount())
                        .status(saving.getStatus())
                        .bankName(saving.getBank().getName())
                        .customerName(customer.getName())
                        .build())
                .collect(Collectors.toList());

        // 4. Build Detail Response (Manual mapping, no inheritance)
        return CustomerDetailResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .nik(customer.getNik())
                .status(customer.getStatus())
                .createdAt(customer.getCreatedAt())
                .savings(savingDTOs) // List tabungan masuk sini
                .build();
    }

    private CustomerResponseDTO mapToResponse(Customer customer) {
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .nik(customer.getNik())
                .status(customer.getStatus())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}