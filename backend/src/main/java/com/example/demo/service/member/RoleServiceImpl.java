package com.example.demo.service.member;

import com.example.demo.entity.member.Role;
import com.example.demo.repository.member.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
