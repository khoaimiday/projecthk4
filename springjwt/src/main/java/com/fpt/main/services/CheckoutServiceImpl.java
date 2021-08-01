package com.fpt.main.services;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fpt.main.dto.Purchase;
import com.fpt.main.dto.PurchaseResponse;
import com.fpt.main.entity.Customer;
import com.fpt.main.entity.Order;
import com.fpt.main.entity.OrderItem;
import com.fpt.main.reponsitory.CustomerRespository;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	private CustomerRespository customerRespository;
	
	public CheckoutServiceImpl(CustomerRespository customerRespository) {
		this.customerRespository = customerRespository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		//retrieve the order info from dto
		Order order = purchase.getOrder();
		
		//generatr tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with orderItem
		Set<OrderItem> orderItems = purchase.getOrderItem();
		orderItems.forEach(item -> order.add(item));
		
		//populate order with shippingAddress
		order.setShippingAddress(purchase.getShippingAddress());
		
		//populate customer with order		
		Customer customer = purchase.getCustomer();
		
		//Check if this is an existsing customer
		String theEmail = customer.getEmail();		
		Customer customerFromDB = customerRespository.findByEmail(theEmail); //return null if not found
		
		if (customerFromDB != null) {
			customer = customerFromDB;
		}
		
		customer.add(order);
		
		//save to the database
		customerRespository.save(customer);
		
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();
	}

}
