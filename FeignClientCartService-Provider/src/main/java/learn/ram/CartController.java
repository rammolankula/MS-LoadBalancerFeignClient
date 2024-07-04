package learn.ram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.ram.model.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/msg")
	public String getMsg() {
		return "To Cart::"+port;
	}

	@GetMapping("/data")
	public ResponseEntity<String> getData(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
	
	@GetMapping(value = "/ob/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> getObj(@PathVariable String code) {
		Cart cart=new Cart(101,code,100.0);
		System.out.println("CartController.getObj()"+cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	@PostMapping(value = "/createCart",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		return ResponseEntity.ok(cart);
	}
}
