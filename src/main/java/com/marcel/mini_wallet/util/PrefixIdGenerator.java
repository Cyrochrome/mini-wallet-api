package com.marcel.mini_wallet.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class PrefixIdGenerator implements IdentifierGenerator {

    private final String prefix;

    /**
     * Kita sederhanakan constructornya.
     * Hibernate akan menyuntikkan konfigurasi @GeneratedPrefixId ke sini.
     */
    public PrefixIdGenerator(GeneratedPrefixId config) {
        this.prefix = config.value();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        // Hapus .toString() karena UUID + String otomatis jadi String
        // Ini menghilangkan warning "Unnecessary toString()"
        return prefix + "-" + UUID.randomUUID();
    }
}