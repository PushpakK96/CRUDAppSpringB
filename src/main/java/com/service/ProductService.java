package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

import com.exception.ResourceNotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(String id) {
        return productRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(String id, Product newProduct) {
        Product existingProduct = productRepository.findById(id)
                                                   .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        return productRepository.save(existingProduct);
    }
    
    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        productRepository.delete(product);
    }
}
