package com.xlx.service.user.impl;

import com.xlx.entity.user.SysUser;
import com.xlx.repository.user.UserRepository;
import com.xlx.service.user.UserService;
import com.xlx.dto.userDomain.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * save user info to Database
     * @param dto userDetail
     */
    @Override
    public void userRegister(UserRegisterDTO dto){
        if (userRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("The user has been exist!");
        }

//        encoded password
        String encryptPassword = passwordEncoder.encode(dto.getPassword());
//        save into database
        SysUser sysUser = SysUser.builder()
                .username(dto.getUsername())
                .password(encryptPassword)
                .email(dto.getEmail())
                .createTime(LocalDateTime.now())
                .createBy("system")
                .updateBy("System")
                .updateTime(LocalDateTime.now())
                .build();
        userRepository.save(sysUser);
    }



}
