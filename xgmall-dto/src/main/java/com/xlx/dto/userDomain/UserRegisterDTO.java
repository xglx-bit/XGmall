package com.xlx.dto.userDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class UserRegisterDTO {
    @NotBlank(message = "Name cannot be empty!")
    @Size(min = 3,max =20 ,message="Username length must be between 3 and 20")
    private String username;

    @Getter
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 6,max = 100,message = "Password must be at least characters!")
    private String password;

    @Pattern(regexp = "^1\\d{10}$", message = "Invalid phone number format ")
    private String phone;

}
