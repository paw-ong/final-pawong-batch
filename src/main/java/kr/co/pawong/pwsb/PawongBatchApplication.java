package kr.co.pawong.pwsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PawongBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawongBatchApplication.class, args);
	}
}
