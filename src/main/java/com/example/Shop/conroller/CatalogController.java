package com.example.Shop.conroller;

import com.example.Shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/items/{Category}")
public class ItemsController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String GetItems(Model model,
                           @PathVariable("Category") String category,
                           @RequestParam(name = "page") Optional<Integer> page,
                           @RequestParam(name = "priceFrom") Optional<Integer> minPrice,
                           @RequestParam(name = "priceTo") Optional<Integer> maxPrice,
                           @RequestParam(name = "q") Optional<String> query
                           )
    {
        int current_page = page.orElse(0);
        if (current_page < 1) current_page = 1;
        if (query.isPresent()){
            int max_page = itemService.countAllWithName(query.get(), current_page,12);
            model.addAttribute("MaxPage",max_page);
            if (max_page == 0){

                return "items";
            }
            if (current_page > max_page) current_page = max_page;
            model.addAttribute("MaxPage",max_page);
            model.addAttribute("Page", current_page);
            model.addAttribute("Items", itemService.getByPageWithName(query.get(), current_page-1,12));
            return "items";
        }
        if (minPrice.isPresent() || maxPrice.isPresent()){
            int max_page = itemService.countAllWithPrice(minPrice.orElse(0), maxPrice.orElse(9999999), 12);
            System.out.println(max_page);
            model.addAttribute("MaxPage",max_page);
            if (max_page == 0){

                return "items";
            }
            if (current_page > max_page) current_page = max_page;
            model.addAttribute("Page", current_page);
            model.addAttribute("Items",  itemService.getByPageWithPrice(minPrice.orElse(0), maxPrice.orElse(9999999),current_page-1,12));
            return "items";
        }
        int max_page = itemService.countAll(current_page, 12);
        model.addAttribute("MaxPage",max_page);
        if (current_page > max_page) current_page = max_page;
        model.addAttribute("Page", current_page);
        model.addAttribute("Items",  itemService.getByPage(current_page-1,12));
        return  "items";
    }

}
