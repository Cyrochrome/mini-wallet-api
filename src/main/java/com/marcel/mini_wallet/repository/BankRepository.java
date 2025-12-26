package com.marcel.mini_wallet.repository;

import com.marcel.mini_wallet.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
    // Mencari bank berdasarkan kode unik (misal: "014" untuk BCA)
    Optional<Bank> findByCode(String code);
}