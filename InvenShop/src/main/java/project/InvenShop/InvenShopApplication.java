package project.InvenShop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InvenShopApplication {
	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {

		SpringApplication.run(InvenShopApplication.class, args);
	}

}
