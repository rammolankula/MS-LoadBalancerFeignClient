package learn.ram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;
import learn.ram.consumer.CartConsumer;
import learn.ram.consumer.model.Cart;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
	@Autowired
	private CartConsumer consumer;
	
	@GetMapping("/msg")
	public String getPay() {
		return "FROM PAYMENT==>"+consumer.findMsg();
	}

	@GetMapping("/data")
	public String getPayment() {
		return "From Pay===>"+consumer.getData();
	}
	
	@GetMapping(value = "/obj",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPaymentCart() {
		return "FROM PAY CART===>"+consumer.getObj("ABC");
	}
	
	@PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPaymentCartObj() {
		return "FROM PAY CART===>"+consumer.createCart(new Cart(101,"ABC",100.00));
	}
}
