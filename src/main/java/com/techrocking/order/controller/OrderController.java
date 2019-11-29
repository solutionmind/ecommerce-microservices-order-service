package com.techrocking.order.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techrocking.order.data.converter.OrderDataConverter;
import com.techrocking.order.entity.Order;
import com.techrocking.order.payload.CreateOrderRequest;
import com.techrocking.order.payload.CreateOrderResponse;
import com.techrocking.order.payload.GetOrderResponse;
import com.techrocking.order.service.OrderService;

@RestController
@EnableDiscoveryClient
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderDataConverter converter;
	
	@Value("${order.service.message}")
	private String message;
	
	@GetMapping
	public GetOrderResponse getOrder() {
		return converter.convert(service.getOrder());
	}
	
	@GetMapping("{id}")
	public GetOrderResponse getOrder(@PathVariable(value = "id") Long orderId) {
		Order order = service.getOrder(orderId);
		return converter.convert(Arrays.asList(order));
	}
	
	@PostMapping()
	public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request) {
		Order order = service.createOrder(request);
		CreateOrderResponse response = new CreateOrderResponse();
		response.setMessage("order created successfully");
		response.setOrderId(order.getId());
		return response;
	}
	
	@GetMapping("ping")
	public String ping() {
		return message;
	}

}
