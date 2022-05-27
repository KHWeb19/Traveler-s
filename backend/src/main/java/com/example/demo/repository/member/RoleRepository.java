package com.example.demo.repository.member;

import com.example.demo.entity.member.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
