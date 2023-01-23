package com.manilov.shop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "prod")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer count;
    private Integer price;
    private String description;
    private String imageLink;
    @ElementCollection(targetClass = Category.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "prod_category", joinColumns = @JoinColumn(name = "prod_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> categorys;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }
}
