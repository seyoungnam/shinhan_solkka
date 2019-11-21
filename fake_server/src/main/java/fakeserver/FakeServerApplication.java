package fakeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://127.0.0.1:8001", "http://localhost:8001" })
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"fakeserver.controller", "fakeserver.service"})
public class FakeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeServerApplication.class, args);
	}

}
