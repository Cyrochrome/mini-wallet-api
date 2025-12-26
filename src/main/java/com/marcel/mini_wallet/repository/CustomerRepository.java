package com.marcel.mini_wallet.repository;

import com.marcel.mini_wallet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Cari customer berdasarkan NIK
    Optional<Customer> findByNik(String nik);

    // Cek apakah NIK sudah terdaftar (untuk validasi register)
    boolean existsByNik(String nik);
}