package com.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    private FeatureToggleService featureToggleService;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id).filter(Product::isActive);
    }

    public Product save(Product product){
        return this.productRepository.save(product);
    }

    public Product update(Product product){
        return this.productRepository.save(product);
    }

    public void deleteById(Long id){
        this.productRepository.deleteById(id);
    }

    public Product patch(Product existingProduct, Product product){
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        return productRepository.save(existingProduct);
    }

}
