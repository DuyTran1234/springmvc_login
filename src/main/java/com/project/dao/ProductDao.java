package com.project.dao;

import java.util.List;

import com.project.entity.Product;

public interface ProductDao {	
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
	public Product getProductById(int id);
	public List<Product> getAllProduct();
}
