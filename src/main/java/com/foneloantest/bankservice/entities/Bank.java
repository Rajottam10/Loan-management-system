package com.foneloantest.bankservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "banks")
@Getter
@Setter
@RequiredArgsConstructor
public class Bank extends AbstractEntity{
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "bank_code", nullable = false)
    private String bankCode;
}
