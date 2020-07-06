package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.CartItem;
import com.project.model.TransactionHistoryDTO;
import com.project.model.UserDTO;
import com.project.service.ProductService;
import com.project.service.TransactionHistoryService;

@Controller
public class ViewProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	@RequestMapping(value = "/xem-san-pham")
	public String viewProduct(HttpServletRequest request) {
		request.setAttribute("listProduct", this.productService.getAllProduct());
		return "ViewProduct";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam(name = "id") int productId, HttpServletRequest request, HttpSession session) {
		List<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cartSession");
		if(items == null) {
			items = new ArrayList<CartItem>();
			CartItem cartItem = new CartItem();
			cartItem.setProductId(productId);
			cartItem.setQuantityOrder(1);
			cartItem.setProductDTO(productService.getProductById(productId));
			items.add(cartItem);
			session.setAttribute("cartSession", items);
		}
		else {
			boolean flag = false;
			for(int i = 0; i < items.size(); i++) {
				CartItem item = items.get(i);
				if(item.getProductId() == productId) {
					item.setQuantityOrder(item.getQuantityOrder() + 1);
					session.setAttribute("cartSession", items);
					flag = true;
					break;
				}
			}
			if(flag != true) {
				CartItem cartItem = new CartItem();
				cartItem.setProductId(productId);
				cartItem.setQuantityOrder(1);
				cartItem.setProductDTO(productService.getProductById(productId));
				items.add(cartItem);
				session.setAttribute("cartSession", items);
			}
		}
		return "redirect:/xem-san-pham";
	}
	
	@RequestMapping(value = "/xem-gio-hang")
	public String viewCart() {
		return "ViewCart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/payment-cart-controller", method = RequestMethod.POST)
	public String paymentCartController(HttpSession session, HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) session.getAttribute("userSession");
		List<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cartSession");
		for(CartItem item : items) {
			item.setId();
			item.setUserId(userDTO.getId());
			item.setDate();
			transactionHistoryService.addTransactionHistory(item);
		}
		session.removeAttribute("cartSession");
		return "redirect:/xem-gio-hang";
	}
	
	@RequestMapping(value = "/user/lich-su-giao-dich")
	public String viewTransactionHistory(HttpServletRequest request, HttpSession session) {
		int id = ((UserDTO) session.getAttribute("userSession")).getId();
		List<TransactionHistoryDTO> listTransactionHistory = transactionHistoryService.getTransactionHistoryByUserId(id);
		for(int i = 0; i < listTransactionHistory.size(); i++) {
			TransactionHistoryDTO dto = listTransactionHistory.get(i);
			dto.setProductDTO(productService.getProductById(dto.getProductId()));
		}
		request.setAttribute("listTransactionHistory", listTransactionHistory);
		return "TransactionHistory";
	}
}
