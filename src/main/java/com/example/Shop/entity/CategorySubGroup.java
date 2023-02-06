package com.example.Shop.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_sub_group")
public class Category2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category parent;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    private List<Category3> itemTypes;

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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category3> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<Category3> itemTypes) {
        this.itemTypes = itemTypes;
    }
}
