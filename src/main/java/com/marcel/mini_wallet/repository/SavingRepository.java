package com.marcel.mini_wallet.repository;

import com.marcel.mini_wallet.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingRepository extends JpaRepository<Saving, String> {

    // Cari berdasarkan nomor rekening (misal: "1001-014-...")
    Optional<Saving> findByNumber(String number);

    // Cari semua rekening milik 1 customer
    List<Saving> findByCustomerId(String customerId);

    // Cek apakah nomor rekening sudah dipakai
    boolean existsByNumber(String number);
}