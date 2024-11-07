package com.springboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductRepository {
    private final List<Product> products;

    public ProductRepository(){
        this.products = buildDummyProducts();
    }

    private List<Product> buildDummyProducts(){
        Product p1 = new Product();
        p1.setId(1L);
        p1.setName("Bottle");
        p1.setPrice(20.12);
        Product p2 = new Product();
        p2.setId(2L);
        p2.setName("Table");
        p2.setPrice(40.99);
        Product p3 = new Product();
        p3.setId(3L);
        p3.setName("Hammer");
        p3.setPrice(7.98);
        Product p4 = new Product();
        p4.setId(5L);
        p4.setName("Saw");
        p4.setPrice(14.56);
        Product p5 = new Product();
        p5.setId(6L);
        p5.setName("Video Game Controller");
        p5.setPrice(39.94);

        List<Product> dummyProducts = new ArrayList<>();
        dummyProducts.add(p1);
        dummyProducts.add(p2);
        dummyProducts.add(p3);
        dummyProducts.add(p4);
        dummyProducts.add(p5);
        return dummyProducts;
    }

    public List<Product> findAll(){
        return this.products;
    }

    public Optional<Product> findById(Long id){
        Optional<Product> ret = Optional.empty();
        List<Product> filteredProducts = this.products.stream().filter(p -> Objects.equals(p.getId(), id)).collect(Collectors.toList());
        if(!filteredProducts.isEmpty()){
            ret = Optional.of(filteredProducts.get(0));
        }
        return ret;
    }

    private Long findMaxId() {
        return this.products.stream().map(Product::getId).reduce(Long::max).orElse(0L);
    }

    public Product add(Product product){
        Long maxId = findMaxId();
        product.setId(maxId + 1);
        this.products.add(product);
        return product;
    }

    public Product update(Product product){
        int index = this.indexOf(product);
        this.products.set(index, product);
        return product;
    }

    public void delete(Product product){
        int index = this.indexOf(product);
        this.products.remove(index);
    }

    public Product patch(Product existingProduct, Product product){
        int index = this.indexOf(existingProduct);
        if(index != -1) {
            if (product.getName() != null) {
                existingProduct.setName(product.getName());
            }
            if (product.getPrice() != null) {
                existingProduct.setPrice(product.getPrice());
            }
            // Repeat for other fields
            this.products.set(index, existingProduct);
            return existingProduct;
        }
        return null;
    }

    private int indexOf(Product product) {
        int index = 0;
        for (Product p:this.products) {
            if(Objects.equals(product.getId(), p.getId()))
                return index;
            index++;
        }
        return -1;
    }

}

