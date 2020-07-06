package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.ProductDTO;
import com.project.service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AdminFeaturesProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/danh-sach-san-pham")
	public String getAllProduct(HttpServletRequest request) {
		request.setAttribute("listProduct", productService.getAllProduct());
		return "AdminListProduct";
	}
	
	@RequestMapping(value = "/them-san-pham")
	public String addProduct(HttpServletRequest request) {
		request.setAttribute("addProduct", new ProductDTO());
		return "AdminAddProduct";
	}
	
	@RequestMapping(value = "/add-product-controller", method = RequestMethod.POST)
	public String addProductController(@ModelAttribute("addProduct") ProductDTO productDTO) {
		productService.addProduct(productDTO);
		return "redirect:/admin/danh-sach-san-pham";
	}
	
	@RequestMapping(value = "/cap-nhat-san-pham")
	public String updateProduct(@RequestParam("id") int id, HttpServletRequest request) {
		request.setAttribute("updateProduct", productService.getProductById(id));
		return "AdminUpdateProduct";
	}
	
	@RequestMapping(value = "/update-product-controller", method = RequestMethod.POST)
	public String updateProductController(@ModelAttribute("updateProduct") ProductDTO productDTO,
			HttpServletRequest request) {
		productService.updateProduct(productDTO);
		return "redirect:/admin/danh-sach-san-pham";
	}
	
	@RequestMapping(value = "/xoa-san-pham")
	public String deleteProduct(@RequestParam("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/admin/danh-sach-san-pham";
	}
}
