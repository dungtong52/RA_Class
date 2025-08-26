package edu.controller;

import edu.model.dto.CustomerLogin;
import edu.model.dto.CustomerRegister;
import edu.model.entity.Customer;
import edu.model.entity.RoleName;
import edu.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/auth/register")
    public String registerCustomer(Model model) {
        CustomerRegister  customerRegister = new CustomerRegister();
        model.addAttribute("customerRegister", customerRegister);
        return "customer/customerRegister";
    }

    @PostMapping("/auth/register")
    public String doRegisterCustomer(@Valid @ModelAttribute("customerRegister")CustomerRegister customerRegister, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return  "customer/customerRegister";
        }else{
            if(customerService.checkUsernameExisted(customerRegister.getUsername())){
                bindingResult.rejectValue("username",null, "Username đã tồn tại");
                return  "customer/customerRegister";
            }
            if(!customerService.checkConfirmPassword(customerRegister.getPassword(),  customerRegister.getConfirmPassword())){
                bindingResult.rejectValue("password",null, "Confirm password không trùng với password");
                return  "customer/customerRegister";
            }
            if(customerService.checkEmailExisted(customerRegister.getEmail())){
                bindingResult.rejectValue("email",null, "Email đã tồn tại");
                return  "customer/customerRegister";
            }
            if(customerService.checkPhoneExisted(customerRegister.getPhone())){
                bindingResult.rejectValue("phone", null,"Phone đã tồn tại");
                return  "customer/customerRegister";
            }

            Customer customer = Customer.builder()
                    .username(customerRegister.getUsername())
                    .password(BCrypt.hashpw(customerRegister.getPassword(), BCrypt.gensalt(12)))
                    .email(customerRegister.getEmail())
                    .phone(customerRegister.getPhone())
                    .role(customerRegister.getRole())
                    .build();
            Customer insertedCustomer = customerService.insertCustomer(customer);
            if(insertedCustomer != null){
               // model.addAttribute("success", insertedCustomer);
                CustomerLogin customerLogin = new CustomerLogin();
                model.addAttribute("customerLogin", customerLogin);
                return "customer/login";
            }else{
                model.addAttribute("error","Không tạo được tài khoản!");
                return "customer/customerRegister";
            }
        }
    }

    @PostMapping("/auth/login")
    public String login(@Valid @ModelAttribute("customerLogin")CustomerLogin customerLogin, BindingResult bindingResult, Model model, HttpSession session) {
        if(bindingResult.hasErrors()){
            return  "customer/customerRegister";
        }
        Customer customer = customerService.login(customerLogin.getUsername(), customerLogin.getPassword());
        if(customer != null){
            session.setAttribute("user", customer);
            if(customer.getRole().equals(RoleName.ROLE_ADMIN)){
                return "admin/home";
            }else{
                return "user/home";
            }
        }else{
            model.addAttribute("error","Sai username hoặc pasword!");
            return "customer/login";
        }
    }
}
