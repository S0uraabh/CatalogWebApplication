package com.PaymentGateway.SpringBootRazorPay.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Service
public class RazorpayService {

	@Value("${razorpay.api.key}")
	private String apiKey;
	
	@Value("${razorpay.api.secret}")
	private String apiSecret;
	
	public String createOrder(int amount, String currency, String receiptId) throws RazorpayException
	{
		RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amount * 100); // 100 * PAISE to convert into RUPEES. 
		orderRequest.put("currency", currency);
		orderRequest.put("receipt", receiptId);
		
		Order order = (Order) razorpayClient.orders.create(orderRequest);
		return order.toString();
	}
	
}
