package com.ziejacode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingListProjectApplication {

	public static void main(String[] args) {
		
		System.out.println("\nThis is test for shopping list 1 \n");
		
		SpringApplication.run(ShoppingListProjectApplication.class, args);
		
		System.out.println("\nThis is test for shopping list 2 \n");
	}

}
