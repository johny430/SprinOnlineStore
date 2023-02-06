package com.example.Shop.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_group")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    private List<Category2> subCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category2> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category2> subCategories) {
        this.subCategories = subCategories;
    }
}
