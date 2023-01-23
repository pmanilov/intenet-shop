package com.manilov.shop.service;

import com.manilov.shop.domain.Product;
import com.manilov.shop.domain.UsersBuckets;
import com.manilov.shop.repos.ProductRepository;
import com.manilov.shop.repos.UserRepository;
import com.manilov.shop.repos.UsersBucketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BucketService {
    @Autowired
    UsersBucketsRepository usersBucketsRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public List<UsersBuckets> findAllByUserId(Long user_id) {
        return usersBucketsRepository.findAllByUserId(user_id);
    }

    public List<Product> getProductList(Principal principal) {
        Integer total = 0;
        List<Product>  productList = new ArrayList<>();
        List<UsersBuckets> listBuckets = usersBucketsRepository.findAllByUserId(userRepository.findByUsername(principal.getName()).getId());
        for(UsersBuckets ub:listBuckets){
            ub.getProduct().setCount(ub.getCount());
            productList.add(ub.getProduct());
            total += ub.getProduct().getCount()*ub.getProduct().getPrice();
        }
        return productList;
    }
    public Integer getTotal(Principal principal) {
        Integer total = 0;
        List<Product>  productList = new ArrayList<>();
        List<UsersBuckets> listBuckets = usersBucketsRepository.findAllByUserId(userRepository.findByUsername(principal.getName()).getId());
        for(UsersBuckets ub:listBuckets){
            ub.getProduct().setCount(ub.getCount());
            productList.add(ub.getProduct());
            total += ub.getProduct().getCount()*ub.getProduct().getPrice();
        }
        return total;
    }
    public void addToBucket(Principal principal, Long productId, Integer count){
        List<UsersBuckets> listBuckets = usersBucketsRepository.findAllByUserId(userRepository.findByUsername(principal.getName()).getId());
        Product product = productRepository.findById(productId).get();
        for(UsersBuckets ub:listBuckets) {
            if (ub.getProduct().getId() == product.getId()) {
                product.setCount(product.getCount() - count);
                ub.setCount(ub.getCount() + count);
                usersBucketsRepository.save(ub);
                return;
            }
        }
        UsersBuckets usersBuckets = new UsersBuckets();
        usersBuckets.setUser(userRepository.findByUsername(principal.getName()));
        product.setCount(product.getCount() - count);
        usersBuckets.setProduct(product);
        usersBuckets.setCount(count);
        usersBucketsRepository.save(usersBuckets);
    }

    public void deleteFromBucket(Product product, Principal principal, Integer count) {
        List<UsersBuckets> listBuckets = usersBucketsRepository.findAllByUserId(userRepository.findByUsername(principal.getName()).getId());
        for(UsersBuckets ub:listBuckets){
            if(ub.getProduct().getId() == product.getId()){
                productRepository.findById(product.getId()).get().setCount(productRepository.findById(product.getId()).get().getCount()+count);
                usersBucketsRepository.delete(ub);
                break;
            }
        }
    }

    public void buy(Principal principal) {
        List<UsersBuckets> listBuckets = usersBucketsRepository.findAllByUserId(userRepository.findByUsername(principal.getName()).getId());
        for(UsersBuckets ub:listBuckets){
            usersBucketsRepository.delete(ub);
        }
    }
}
