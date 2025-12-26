package com.marcel.mini_wallet.controller;

import com.marcel.mini_wallet.dto.SavingRequestDTO;
import com.marcel.mini_wallet.dto.SavingResponseDTO;
import com.marcel.mini_wallet.dto.WebResponse;
import com.marcel.mini_wallet.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings")
@RequiredArgsConstructor
public class SavingController {

    private final SavingService savingService;

    @PostMapping
    public ResponseEntity<WebResponse<SavingResponseDTO>> create(@RequestBody SavingRequestDTO request) {
        SavingResponseDTO result = savingService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WebResponse.<SavingResponseDTO>builder()
                        .status(201)
                        .message("Success create saving account")
                        .data(result)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<SavingResponseDTO>> getById(@PathVariable("id") String id) {
        SavingResponseDTO result = savingService.getById(id);
        return ResponseEntity.ok(WebResponse.<SavingResponseDTO>builder()
                .status(200)
                .message("Success get detail saving")
                .data(result)
                .build());
    }

    // Get All Savings (Bisa dipakai Admin)
    @GetMapping
    public ResponseEntity<WebResponse<List<SavingResponseDTO>>> getAll() {
        List<SavingResponseDTO> result = savingService.getAll();
        return ResponseEntity.ok(WebResponse.<List<SavingResponseDTO>>builder()
                .status(200)
                .message("Success get all saving accounts")
                .data(result)
                .build());
    }
}