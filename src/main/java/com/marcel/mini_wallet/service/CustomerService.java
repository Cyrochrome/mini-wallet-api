package com.marcel.mini_wallet.service;

import com.marcel.mini_wallet.dto.CustomerDetailResponseDTO;
import com.marcel.mini_wallet.dto.CustomerRequestDTO;
import com.marcel.mini_wallet.dto.CustomerResponseDTO;
import java.util.List;

public interface CustomerService {
    CustomerResponseDTO create(CustomerRequestDTO request);
    List<CustomerResponseDTO> getAll();

    // Fitur tugas screenshot
    CustomerDetailResponseDTO getDetailByNik(String nik);
}