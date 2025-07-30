package com.foneloantest.bankservice.services;

import com.foneloantest.bankservice.entities.Bank;

import java.util.List;

public interface BankService {
    Bank createBank(Bank bank);
    Bank getBankByCode(String bankCode);
    List<Bank> getAllBanks();
    Bank updateBank(Bank bank, String bankCode);
    void deleteBank(String bankCode);
}
