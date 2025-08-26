package edu.service;

import edu.model.entity.Customer;

public interface CustomerService {
    boolean checkUsernameExisted(String username);
    boolean checkEmailExisted(String email);
    boolean checkPhoneExisted(String phone);
    Customer insertCustomer(Customer customer);
    Customer login(String username, String password);
    boolean checkConfirmPassword(String password, String confirmPassword);
}
