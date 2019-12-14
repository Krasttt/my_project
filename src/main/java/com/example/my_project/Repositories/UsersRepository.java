package com.example.my_project.Repositories;

import com.example.my_project.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
