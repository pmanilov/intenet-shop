package com.manilov.shop.controller;

import com.manilov.shop.domain.Category;
import com.manilov.shop.domain.Product;
import com.manilov.shop.service.ProductService;
import com.manilov.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.EnumSet;

import static com.manilov.shop.domain.Role.ADMIN;


@Controller
public class ProductsController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @GetMapping("/products")
    public String products(Principal principal, Model model) {
        Boolean root = userService.findUserByUsername(principal.getName()).getRoles().contains(ADMIN);
        model.addAttribute("products", productService.findAll());
        model.addAttribute("root", root);
        model.addAttribute("message", "");
        EnumSet<Category> categorys = EnumSet.allOf(Category.class);
        model.addAttribute("categorys", categorys);
        return "products";
    }

    @GetMapping("/product/{product}")
    public String productInfo(@PathVariable Product product, Model model) {
        model.addAttribute("product", productService.findById(product.getId()).get());
        EnumSet<Category> categorys = EnumSet.allOf(Category.class);
        model.addAttribute("categorys", categorys);
        return "productInfo";
    }
    @GetMapping("/products/{category}")
    public String productsCategory(@PathVariable Category category, Principal principal, Model model) {
        Boolean root = userService.findUserByUsername(principal.getName()).getRoles().contains(ADMIN);
        model.addAttribute("products", productService.findByCategorys(category));
        model.addAttribute("root", root);
        model.addAttribute("message", "");
        EnumSet<Category> categorys = EnumSet.allOf(Category.class);
        model.addAttribute("categorys", categorys);
        return "products";
    }

    @GetMapping("/products/search")
    public String productsSearch(@RequestParam String value, Principal principal, Model model) {
        Boolean root = userService.findUserByUsername(principal.getName()).getRoles().contains(ADMIN);
        model.addAttribute("products", productService.searchByName(value));
        EnumSet<Category> categorys = EnumSet.allOf(Category.class);
        model.addAttribute("categorys", categorys);
        model.addAttribute("root", root);
        model.addAttribute("message", "Found for your request \""+value+"\":");
        return "products";
    }
}
