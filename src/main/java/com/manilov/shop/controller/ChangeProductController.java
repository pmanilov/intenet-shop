package com.manilov.shop.controller;

import com.manilov.shop.domain.Category;
import com.manilov.shop.domain.Product;
import com.manilov.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/products")
public class ChangeProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/delete/{product}")
    public String productDelete(@PathVariable Product product) {
        productService.delete(product);
        return "redirect:/products/edit";
    }

    @GetMapping("/edit")
    public String productList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "productList";
    }
    @GetMapping("/edit/{product}")
    public String productEdit(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);
        model.addAttribute("categorys", Category.values());
        model.addAttribute("error", "");
        return "productEdit";
    }
    @PostMapping("/edit/{product}")
    public String formEditProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam String count,
            @RequestParam String imageLink,
            @RequestParam Map<String, String> form,
            @RequestParam("productId") Product product,
            Model model) {
        if(name.equals("")||price.equals("")||count.equals("")||imageLink.equals("") ||
                name.replaceAll(" ","").equals("")||imageLink.replaceAll(" ","").equals("")) {
            model.addAttribute("product", product);
            model.addAttribute("categorys", Category.values());
            model.addAttribute("error", "Incorrect values");
            return "productEdit";
        }
        price = price.replaceAll(" ", "").replaceAll(" ", "");
        count = count.replaceAll(" ", "").replaceAll(" ", "");
        if(!price.matches("^\\d+$") || !count.matches("^\\d+$")) {
            model.addAttribute("product", product);
            model.addAttribute("categorys", Category.values());
            model.addAttribute("error", "Incorrect values");
            return "productEdit";
        }
        productService.changeProduct(product, name,description,price,count,imageLink,form);
        return "redirect:/products/edit";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("categorys", Category.values());
        model.addAttribute("error", "");
        return "productAdd";
    }

    @PostMapping("/add")
    public String formAddProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam String count,
            @RequestParam String imageLink,
            @RequestParam Map<String, String> form,
            Model model){
        if(name.equals("")||price.equals("")||count.equals("")||imageLink.equals("")||
                name.replaceAll(" ","").equals("")||imageLink.replaceAll(" ","").equals("")) {
            model.addAttribute("categorys", Category.values());
            model.addAttribute("error", "Incorrect values");
            return "productAdd";
        }
        price = price.replaceAll(" ", "").replaceAll(" ", "");
        count = count.replaceAll(" ", "").replaceAll(" ", "");
        if(!price.matches("^\\d+$") || !count.matches("^\\d+$")) {
            model.addAttribute("categorys", Category.values());
            model.addAttribute("error", "Incorrect values");
            return "productAdd";
        }
        Product product = new Product();
        productService.changeProduct(product, name,description,price,count,imageLink,form);
        return "redirect:/products";
    }
}
