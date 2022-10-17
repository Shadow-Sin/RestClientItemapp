package com.itemrestclient.itemrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.controller","com.itemrestclient.itemrestclient"} )

public class ItemrestclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemrestclientApplication.class, args);
	}

}
