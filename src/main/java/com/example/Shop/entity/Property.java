package com.example.Shop.entity;


import javax.persistence.*;

@Entity
@Table(name = "item_property")
public class ItemProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category3 itemType;

    @Column(name = "")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category3 getItemType() {
        return itemType;
    }

    public void setItemType(Category3 itemType) {
        this.itemType = itemType;
    }
}
