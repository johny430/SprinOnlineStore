package com.example.Shop.conroller;

import com.example.Shop.service.ShopUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ShopUserDetailsService userService;

    @GetMapping
    public String StartPage(Model model){
        model.addAttribute("Users",userService.getAllUsers());
        return  "index";
    }
}
