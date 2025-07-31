package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public String saveProduct(Product p) {
		
		// Genearted ID starts with P;
		long count = productRepo.count() + 1;
		String newId = String.format("P%03d", count);
		p.setProductId(newId);
		productRepo.save(p);
		return "Success: Product Added";
	}
	
	public List<Product> getAllProdut() {
		return productRepo.findAll();
	}
	
	public Product getByName(String name) {
		return productRepo.findByName(name).orElseThrow(() -> new RuntimeException("Product not existss"));
	}
	
	public Product updateProduct(String id, Product p) {
		Product existing = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product Not found"));
		
		existing.setName(p.getName());
		existing.setPrice(p.getPrice());
		
		return productRepo.save(p);
	}
	
	public void deleteProduct(String id) {
		if(!productRepo.existsById(id)) {
			throw new RuntimeException("not found");
		}
		productRepo.deleteById(id);
	}
}
