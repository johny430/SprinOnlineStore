package com.example.Shop.conroller;

import com.example.Shop.exception.ItemNotFountException;
import com.example.Shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public String getItemById(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("item",itemService.getOne(id));
            return "item";
        } catch (ItemNotFountException e){
            return e.toString();
        }
    }
}
