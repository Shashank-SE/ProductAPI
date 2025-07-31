package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService services;
	
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product p){
		
		String resp = services.saveProduct(p);
		
		if(resp.startsWith("Error")) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(resp);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(services.getAllProdut());
	}
	
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		try {
			return ResponseEntity.ok(services.getByName(name));
		} catch(RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Product p) {
		
		try {
			return ResponseEntity.ok(services.updateProduct(id, p));
		} catch(RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{idr}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		try {
			services.deleteProduct(id);
			return ResponseEntity.ok("Deleted Successfully");
		} catch(RuntimeException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}