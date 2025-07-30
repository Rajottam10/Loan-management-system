package com.foneloantest.bankservice.controllers;

import com.foneloantest.bankservice.entities.Bank;
import com.foneloantest.bankservice.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank){
        return ResponseEntity.ok(bankService.createBank(bank));
    }

    @GetMapping("/{bankCode}")
    public ResponseEntity<Bank> getBankByCode(@PathVariable String bankCode){
        return ResponseEntity.ok(bankService.getBankByCode(bankCode));
    }

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks(){
        return ResponseEntity.ok(bankService.getAllBanks());
    }

    @PutMapping("/update/{bankCode}")
    public ResponseEntity<Bank> updateBank(@RequestBody Bank bank, @PathVariable String bankCode){
        return ResponseEntity.ok(bankService.updateBank(bank, bankCode));
    }

    @DeleteMapping("/delete/{bankCode}")
    public void deleteBank(@PathVariable String bankCode){
        bankService.deleteBank(bankCode);
    }
}
