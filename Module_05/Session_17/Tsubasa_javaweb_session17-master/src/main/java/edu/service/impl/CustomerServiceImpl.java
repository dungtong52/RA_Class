package edu.service.impl;

import edu.model.entity.Customer;
import edu.repo.CustomerRepository;
import edu.service.CustomerService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean checkUsernameExisted(String username) {
        return customerRepository.findByUsername(username)!=null;
    }

    @Override
    public boolean checkEmailExisted(String email) {
        return customerRepository.findByEmail(email)!=null;
    }

    @Override
    public boolean checkPhoneExisted(String phone) {
        return customerRepository.findByPhone(phone)!=null;
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if(BCrypt.checkpw(password,customer.getPassword()))
            return customer;
        else
            return null;
    }

    @Override
    public boolean checkConfirmPassword(String password, String confirmPassword) {
        return password!=null && password.equals(confirmPassword);
    }
}
