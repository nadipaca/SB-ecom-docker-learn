package com.sb.Ecom.services;

import com.sb.Ecom.models.Product;
import com.sb.Ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public void addProduct(Product prod){
         productRepo.save(prod);
    }

    public Product getProductById(int id){
//          return productRepo.findById(id).get();
//        return productRepo.findById(id).orElse(null);
        return productRepo.findById(id).orElse(new Product(-1));
    }
}
