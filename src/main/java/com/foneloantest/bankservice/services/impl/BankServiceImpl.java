package com.foneloantest.bankservice.services.impl;

import com.foneloantest.bankservice.entities.Bank;
import com.foneloantest.bankservice.repositories.BankRepository;
import com.foneloantest.bankservice.services.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank getBankByCode(String bankCode) {
        return bankRepository.loadByBankCode(bankCode);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank updateBank(Bank bank, String bankCode) {
        Bank bank1 = bankRepository.loadByBankCode(bankCode);
        bank1.setName(bank.getName());
        bank1.setBankCode(bank.getBankCode());
        return bankRepository.save(bank1);
    }

    @Override
    public void deleteBank(String bankCode) {
        bankRepository.deleteByBankCode(bankCode);
        System.out.println("The bank with the bank code: "+bankCode+" is deleted.");
    }
}
