package com.project.service;

import java.util.List;

import com.project.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO productDTO);
	public void updateProduct(ProductDTO productDTO);
	public void deleteProduct(int id);
	public ProductDTO getProductById(int id);
	public List<ProductDTO> getAllProduct();
}
