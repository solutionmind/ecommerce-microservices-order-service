package com.techrocking.order.rest.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techrocking.customer.payload.CustomerResponsePayload;
import com.techrocking.item.payload.GetItemResponse;

@Component
public class RestUtil {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	public CustomerResponsePayload getCustomerDetailsByDiscoveryClient(Long customerId) {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = discoveryClient.getInstances("customer-service");
		String customerServiceURI = instances.get(0).getUri().toString();
		
		String serviceUri = String.format("%s/v1/customers/%s",customerServiceURI,customerId.toString());
		
		ResponseEntity<CustomerResponsePayload> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, CustomerResponsePayload.class);
		return restExchange.getBody();
	}
	
	public GetItemResponse getItemDetailsByDiscoveryClient(Long itemId) {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = discoveryClient.getInstances("item-service");
		String itemServiceURI = instances.get(0).getUri().toString();
		
		String serviceUri = String.format("%s/v1/items/%s",itemServiceURI,itemId.toString());
		
		ResponseEntity<GetItemResponse> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, GetItemResponse.class);
		return restExchange.getBody();
	}
	
	public CustomerResponsePayload getCustomerDetailsByRibbonBackedClient(Long customerId) {
		String serviceUri = "http://customer-service/v1/customers/{customerId}";
		
		ResponseEntity<CustomerResponsePayload> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, CustomerResponsePayload.class,customerId.toString());
		return restExchange.getBody();
	}
	
	public GetItemResponse getItemDetailsByRibbonBackedClient(Long itemId) {
		String serviceUri = "http://item-service/v1/items/{itemId}";
		
		ResponseEntity<GetItemResponse> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, GetItemResponse.class,itemId.toString());
		return restExchange.getBody();
	}

}
