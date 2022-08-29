package com.example.Shop.service;

import com.example.Shop.exception.ItemNotFountException;
import com.example.Shop.repository.ItemRepository;
import com.example.Shop.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Iterable<ItemEntity> getAllItems(){
        return itemRepository.findAll();
    }

    public ItemEntity getOne(Long id) throws ItemNotFountException {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFountException("No user with id" + id.toString()));
    }
}
