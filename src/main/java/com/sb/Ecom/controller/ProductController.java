package com.sb.Ecom.controller;

import com.sb.Ecom.models.Product;
import com.sb.Ecom.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product prod){
         productService.addProduct(prod);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getproductbyId(@PathVariable int id){
        Product prod = productService.getProductById(id);
        if(prod.getId() > 0) {
        return new ResponseEntity<>(prod,HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/addProduct")
    public void addStudent(){
        Product p = new Product();
        p.setName("iphone");
        p.setBrand("Apple");
        p.setCategory("Electronics");
        p.setDescription("iphone 16 latest mobile");

        productService.addProduct(p);
    }
}
