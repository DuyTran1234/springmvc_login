package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CartItem {
	private String id;
	
	private ProductDTO productDTO;
	
	private UserDTO userDTO;
	
	private int userId;
	private int productId;
	private String date;
	private int quantityOrder;
	
	public CartItem() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setId() {
		this.id = (new Random().nextInt(9999 - 1001) + 1000) + new Date().getTime() + "" + this.userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDate() {
		return date;
	}
	public void setDate() {
		String pattern = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		this.date = sdf.format(new Date());
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}