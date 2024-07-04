package learn.ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignClientCartServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientCartServiceProviderApplication.class, args);
	}

}
