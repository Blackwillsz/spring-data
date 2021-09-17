package be.com.alura.apring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ApringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApringDataApplication.class, args);
	}

}
