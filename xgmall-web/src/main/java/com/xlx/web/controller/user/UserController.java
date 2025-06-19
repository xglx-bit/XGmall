package com.xlx.web.controller.user;
import com.xlx.common.response.CommonResult;
import com.xlx.dto.userDomain.UserLoginDTO;
import com.xlx.dto.userDomain.UserRegisterDTO;
import com.xlx.security.jwt.JwtTokenProvider;
import com.xlx.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Tag(name = "user API")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    /**
     * user Register
     * @param userRegisterDto Encapsulate the body
     * @return the Result
     */
    @Operation(summary = "Register user",description = "Post email and password")
    @PostMapping("/user-register")
    public CommonResult<Void> userRegister(@Valid @RequestBody UserRegisterDTO userRegisterDto){
        userService.userRegister(userRegisterDto);
        return CommonResult.success(200,"Register successful!",null);
    }


    @PostMapping("/user-login")
    public CommonResult<?> userLogin(@Valid @RequestBody UserLoginDTO loginDto){
        // authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        // generate jwt
        String jwt = jwtTokenProvider.generateToken(authentication);

        return CommonResult.success(200,"Login successful!", Map.of("token",jwt));
    }


    @GetMapping("/hello")
    public CommonResult<Void> helloJwt(){
        return CommonResult.success(200,"Hello Jwt!",null);
    }

}
