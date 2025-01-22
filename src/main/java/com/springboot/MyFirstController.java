package com.springboot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class MyFirstController {
    @Autowired
    private ProductService productService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> allProducts = productService.findAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        Optional<Product> product = productService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Product> add(@RequestBody Product product){
        Product addedProduct = this.productService.save(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Optional<Product> existingProduct = this.productService.findById(product.getId());
        Product updatedProduct;
        if(existingProduct.isPresent()){
            updatedProduct = this.productService.update(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        if(productService.findById(id).isPresent()){
            this.productService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Product> patch(@PathVariable("id") Long id, @RequestBody Product product){
        Optional<Product> existingProductOpt = this.productService.findById(id);
        if(existingProductOpt.isPresent()){
            Product existingProduct = existingProductOpt.get();
            Product patchedProduct = this.productService.patch(existingProduct, product);
            return new ResponseEntity<>(patchedProduct, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
