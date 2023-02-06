package com.example.Shop.repository;

import com.example.Shop.entity.Category3;
import com.example.Shop.entity.ItemProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FiltersRepository extends CrudRepository<ItemProperty,Long> {
    List<ItemProperty> findAllByItemType(Category3 type);
}
