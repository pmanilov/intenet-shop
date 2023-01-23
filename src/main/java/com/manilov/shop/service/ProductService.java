package com.manilov.shop.service;

import com.manilov.shop.domain.Category;
import com.manilov.shop.domain.Product;
import com.manilov.shop.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public void delete(Product product){
        productRepository.delete(product);
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public List<Product> findByCategorys(Category category) {
        return productRepository.findByCategorys(category);
    }

    public void changeProduct(Product product, String name,
                              String description, String price,
                              String count, String imageLink,
                              Map<String, String> form) {
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Integer.valueOf(price));
        product.setCount(Integer.valueOf(count));
        product.setImageLink(imageLink);
        product.setCategorys(new HashSet<Category>());
        Set<String> category = Arrays.stream(Category.values())
                .map(Category::name)
                .collect(Collectors.toSet());
        for (String key : form.keySet()) {
            if (category.contains(key)) {
                product.getCategorys().add(Category.valueOf(key));
            }
        }
        productRepository.save(product);
    }

    public List<Product> searchByName(String value) {
        List<Product> productList = this.findAll();
        List<Product> productAfterSearch = new ArrayList<>();
        for(Product product:productList) {
            if(product.getName().toLowerCase().contains(value.toLowerCase())){
                productAfterSearch.add(product);
            }
        }
        return productAfterSearch;
    }
}
