package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.entity.Product;
import com.project.model.ProductDTO;
import com.project.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		productDao.addProduct(product);
	}

	public void updateProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		productDao.updateProduct(product);
	}

	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	public ProductDTO getProductById(int id) {
		Product product = productDao.getProductById(id);
		if(product == null) {
			return null;
		}
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		return productDTO;
	}

	public List<ProductDTO> getAllProduct() {
		List<Product> listProduct = productDao.getAllProduct();
		if(listProduct == null) {
			return null;
		}
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		for(Product product : listProduct) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());
			listProductDTO.add(productDTO);
		}
		return listProductDTO;
	}
	
}
