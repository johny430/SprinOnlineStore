package com.example.Shop.conroller;

import com.example.Shop.entity.UserEntity;
import com.example.Shop.exception.UserAlreadyExistException;
import com.example.Shop.form.UserForm;
import com.example.Shop.security.AuthenticationManager;
import com.example.Shop.service.ShopUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private ShopUserDetailsService shopUserDetailsService;

    @GetMapping
    public String Registration(UserForm userForm){
        if (AuthenticationManager.isAuthenticated()){
            return "redirect:/me";
        }
        return  "registration";
    }

    @PostMapping
    public String AddUser(@Valid UserForm userForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            UserEntity user = UserForm.toEntity(userForm);
            shopUserDetailsService.registration(user);
            AuthenticationManager.LoginUser(user);
            return "redirect:/me";
        } catch (UserAlreadyExistException e) {
            return "registration";
        }
    }
}
