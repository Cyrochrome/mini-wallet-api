package com.marcel.mini_wallet.controller;

import com.marcel.mini_wallet.dto.*;
import com.marcel.mini_wallet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<WebResponse<CustomerResponseDTO>> create(@RequestBody CustomerRequestDTO request) {
        CustomerResponseDTO result = customerService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WebResponse.<CustomerResponseDTO>builder()
                        .status(201)
                        .message("Success create customer")
                        .data(result)
                        .build());
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<CustomerResponseDTO>>> getAll() {
        List<CustomerResponseDTO> result = customerService.getAll();
        return ResponseEntity.ok(WebResponse.<List<CustomerResponseDTO>>builder()
                .status(200)
                .message("Success get all customers")
                .data(result)
                .build());
    }

    // Endpoint Tugas Screenshot
    @GetMapping("/nik/{nik}")
    public ResponseEntity<WebResponse<CustomerDetailResponseDTO>> getByNik(@PathVariable("nik") String nik) {
        CustomerDetailResponseDTO result = customerService.getDetailByNik(nik);
        return ResponseEntity.ok(WebResponse.<CustomerDetailResponseDTO>builder()
                .status(200)
                .message("Success get customer detail")
                .data(result)
                .build());
    }
}