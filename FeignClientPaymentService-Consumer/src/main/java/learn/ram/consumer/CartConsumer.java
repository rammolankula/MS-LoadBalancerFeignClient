package learn.ram.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import learn.ram.consumer.model.Cart;

@FeignClient("FeignClientCartService-Provider")
public interface CartConsumer {

	@GetMapping("/cart/msg")
	public String findMsg();
	
	@GetMapping("/cart/data")
	public ResponseEntity<String> getData();

	@GetMapping(value = "/cart/ob/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart getObj(@PathVariable String code);
	
	@PostMapping(value = "/cart/createCart",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCart(@RequestBody Cart cart);
	
}
