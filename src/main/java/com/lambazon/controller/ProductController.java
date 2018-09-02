package com.lambazon.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GetMapping("/products")
	public String products	(Model model) {
		model.addAttribute("prods", productService.products());
		model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount());
		return "products";
	}
	
	@GetMapping("/products/{id}/details")
	public String product	(@PathVariable Integer id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}

	/**
	 * Return the total amount of the inventory
	 * @return the total amount
	 */
	private double calculateTotalInventoryAmount() {
		double result = 0;
		// go through the product list in order to retrieve the inventory price for calculate the total amount of the inventory
		for(int i = 0; i < productService.products().size(); i++){
			result = result + productService.products().get(i).getInventoryPrice();
		}
		return result;
		
	}
}
