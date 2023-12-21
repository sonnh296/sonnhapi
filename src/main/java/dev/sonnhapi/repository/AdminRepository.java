package dev.sonnhapi.repository;

import dev.sonnhapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByUser_Username(String username);
}
