package com.example.Shop.repository;

import com.example.Shop.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category3Repository extends CrudRepository<Category, Long> {
    Category findOneByName(String name);
}
