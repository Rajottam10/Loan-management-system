package com.foneloantest.bankservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter

public class Role extends AbstractEntity{

    @Column(nullable = false, unique = true)
    private String name;
}
