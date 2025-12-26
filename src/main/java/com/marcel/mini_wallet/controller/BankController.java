package com.marcel.mini_wallet.controller;

import com.marcel.mini_wallet.dto.BankRequestDTO;
import com.marcel.mini_wallet.dto.BankResponseDTO;
import com.marcel.mini_wallet.dto.WebResponse;
import com.marcel.mini_wallet.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. Tanda bahwa ini adalah pintu gerbang API
@RequestMapping("/api/banks") // 2. Base URL: http://localhost:8080/api/banks
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService; // Panggil (Service)

    // API: Tambah Bank Baru
    // POST /api/banks
    @PostMapping
    public ResponseEntity<WebResponse<BankResponseDTO>> create(@RequestBody BankRequestDTO request) {
        // Suruh Service kerjakan
        BankResponseDTO result = bankService.create(request);

        // Bungkus hasil ke dalam WebResponse
        WebResponse<BankResponseDTO> response = WebResponse.<BankResponseDTO>builder()
                .status(HttpStatus.CREATED.value()) // 201
                .message("Success create new bank")
                .data(result)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // API: Ambil Semua Bank
    // GET /api/banks
    @GetMapping
    public ResponseEntity<WebResponse<List<BankResponseDTO>>> getAll() {
        List<BankResponseDTO> result = bankService.getAll();

        WebResponse<List<BankResponseDTO>> response = WebResponse.<List<BankResponseDTO>>builder()
                .status(HttpStatus.OK.value()) // 200
                .message("Success get all banks")
                .data(result)
                .build();

        return ResponseEntity.ok(response);
    }

    // API: Ambil Satu Bank by ID
    // GET /api/banks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<BankResponseDTO>> getById(@PathVariable("id") String id) {
        BankResponseDTO result = bankService.getById(id);

        WebResponse<BankResponseDTO> response = WebResponse.<BankResponseDTO>builder()
                .status(HttpStatus.OK.value())
                .message("Success get bank detail")
                .data(result)
                .build();

        return ResponseEntity.ok(response);
    }
}