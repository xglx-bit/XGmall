package com.xlx.repository.user;

import com.xlx.entity.user.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<SysUser,Long> {
    boolean existsByEmail(String email);
    Optional<SysUser> findByEmail(String email);
}
