package com.marcel.mini_wallet.controller;

import com.marcel.mini_wallet.dto.TransactionRequestDTO;
import com.marcel.mini_wallet.dto.TransactionResponseDTO;
import com.marcel.mini_wallet.dto.WebResponse;
import com.marcel.mini_wallet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    // API: Transaksi Baru (Deposit / Withdraw)
    // POST /api/transactions
    @PostMapping
    public ResponseEntity<WebResponse<TransactionResponseDTO>> create(@RequestBody TransactionRequestDTO request) {
        TransactionResponseDTO result = transactionService.create(request);

        WebResponse<TransactionResponseDTO> response = WebResponse.<TransactionResponseDTO>builder()
                .status(HttpStatus.CREATED.value())
                .message("Transaction successful")
                .data(result)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // API: Cek Mutasi Rekening
    // GET /api/transactions/{savingId}
    @GetMapping("/{savingId}")
    public ResponseEntity<WebResponse<List<TransactionResponseDTO>>> getHistory(@PathVariable("savingId") String savingId) {
        List<TransactionResponseDTO> result = transactionService.getAllBySavingId(savingId);

        WebResponse<List<TransactionResponseDTO>> response = WebResponse.<List<TransactionResponseDTO>>builder()
                .status(HttpStatus.OK.value())
                .message("Success get transaction history")
                .data(result)
                .build();

        return ResponseEntity.ok(response);
    }
}