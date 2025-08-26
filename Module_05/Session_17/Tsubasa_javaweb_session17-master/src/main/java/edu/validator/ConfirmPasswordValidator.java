package edu.validator;

import edu.model.dto.CustomerRegister;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPasswordMatching, CustomerRegister> {
    @Override
    public boolean isValid(CustomerRegister value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmPassword());
    }
}
