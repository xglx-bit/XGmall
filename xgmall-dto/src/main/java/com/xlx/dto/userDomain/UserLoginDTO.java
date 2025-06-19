package com.xlx.dto.userDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {
    @NotBlank(message = "Account  cannot be empty!")
    @Email(message = "Invalid email format!")
    String email;

    @NotBlank(message = "Please input your password!")
    String password;
}
