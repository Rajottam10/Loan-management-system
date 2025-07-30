package com.foneloantest.bankservice.repositories;

import com.foneloantest.bankservice.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank loadByBankCode(String bankCode);
    void deleteByBankCode(String bankCode);
}
