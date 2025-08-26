package edu.model.dto;

import edu.model.entity.RoleName;
import edu.validator.ConfirmPasswordMatching;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLogin {
    @NotBlank(message = "Username chưa nhập!")
    private String username;
    @NotBlank(message = "Password chưa nhập!")
    private String password;
}
