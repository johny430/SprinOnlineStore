package com.example.Shop.conroller;

import com.example.Shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String GetItems(Model model){
        model.addAttribute("Users",itemService.getAllItems());
        return  "items";
    }

}
