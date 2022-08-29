package com.example.Shop.conroller;

import com.example.Shop.security.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String LoginPage(){
        if(AuthenticationManager.isAuthenticated()){
            return "redirect:me";
        }
        return "login";
    }
}
