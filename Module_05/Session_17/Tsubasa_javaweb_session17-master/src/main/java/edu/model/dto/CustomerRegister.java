package edu.model.dto;

import edu.model.entity.RoleName;
import edu.validator.ConfirmPasswordMatching;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegister {
    @NotBlank(message = "Username chưa nhập!")
    private String username;
    @NotBlank(message = "Password chưa nhập!")
    private String password;
    @NotBlank(message = "Email chưa nhập!")
    private String email;
    @NotBlank(message = "Phone chưa nhập!")
    private String phone;
    @NotNull(message = "Role chưa nhập!")
    private RoleName role;
    private String confirmPassword;
}
