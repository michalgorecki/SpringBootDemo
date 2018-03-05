package pl.mgorecki.storageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StorageappApplication {

	public static void main(String[] args) {
        System.out.println("Application started");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StorageappApplication.class, args);
	}
}
