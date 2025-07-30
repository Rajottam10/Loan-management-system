package com.foneloantest.bankservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class User extends AbstractEntity{
    @Column(name = "username", unique = true)
    @NotBlank(message = "The username cannot be blank")
    private String username;

    @Column(name= "fullname")
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)   //signifies how date and time should be persisted in the db
    private Date createdDate;

    @Enumerated(EnumType.STRING)  //signifies how the enum should be stored in the db
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
