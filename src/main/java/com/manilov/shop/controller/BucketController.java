package com.manilov.shop.controller;

import com.manilov.shop.domain.Category;
import com.manilov.shop.domain.Product;
import com.manilov.shop.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.EnumSet;
import java.util.List;

@Controller
public class BucketController {
    @Autowired
    BucketService bucketService;
    @GetMapping("/cart")
    public String bucketPage(Principal principal, Model model){
        Integer total = bucketService.getTotal(principal);
        List<Product>  productList = bucketService.getProductList(principal);
        model.addAttribute("products", productList);
        model.addAttribute("totalPrice", total);
        EnumSet<Category> categorys = EnumSet.allOf(Category.class);
        model.addAttribute("categorys", categorys);
        return "bucket";
    }
    @PostMapping("/addToCart")
    public String addToBucketForm(Principal principal, @RequestParam(name = "productId") Long productId, @RequestParam(name = "count")Integer count, Model model) {
        bucketService.addToBucket(principal, productId, count);
        return "redirect:/products";
    }
    @GetMapping("/cart/delete/{product}")
    public String deleteFromBucket(@PathVariable Product product,Principal principal,@RequestParam(name = "count") Integer count) {
        bucketService.deleteFromBucket(product, principal, count);
        return "redirect:/cart";
    }

    @GetMapping("/cart/buy")
    public String buy(Principal principal) {
        bucketService.buy(principal);
        return "redirect:/cart";
    }
}
