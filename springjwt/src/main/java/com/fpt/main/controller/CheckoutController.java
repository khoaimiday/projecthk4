package com.fpt.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.fpt.main.dto.Purchase;
import com.fpt.main.dto.PurchaseResponse;
import com.fpt.main.services.CheckoutService;

@Controller
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;
	
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/purchase")
	public ResponseEntity placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
		
		return new ResponseEntity<>("User Created Successfully",HttpStatus.OK);
	}
}
