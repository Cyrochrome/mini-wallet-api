package com.marcel.mini_wallet.repository;

import com.marcel.mini_wallet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    // Ambil history transaksi berdasarkan ID rekening, urutkan dari yang terbaru
    List<Transaction> findBySavingIdOrderByCreatedAtDesc(String savingId);
}