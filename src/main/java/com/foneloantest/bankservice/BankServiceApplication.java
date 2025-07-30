package com.foneloantest.bankservice;

import com.foneloantest.bankservice.entities.Role;
import com.foneloantest.bankservice.entities.Status;
import com.foneloantest.bankservice.entities.User;
import com.foneloantest.bankservice.repositories.RoleRepository;
import com.foneloantest.bankservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class BankServiceApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BankServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Ensure GOD Role exists
        Role godRole = roleRepository.findByName("GOD").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("GOD");
            return roleRepository.save(newRole);
        });

        // Create GOD user if not exists
        String godUsername = "superadmin";
        if (userRepository.findByUsername(godUsername).isEmpty()) {
            User godUser = new User();
            godUser.setUsername(godUsername);
            godUser.setPassword("superadmin123"); // use strong pw in prod
            godUser.setFullName("Super Admin");
            godUser.setEmail("superadmin@bank.com");
            godUser.setCreatedDate(new Date());
            godUser.setStatus(Status.UNBLOCK);
            godUser.setRoles(Set.of(godRole));
            userRepository.save(godUser);
        }
    }
}
