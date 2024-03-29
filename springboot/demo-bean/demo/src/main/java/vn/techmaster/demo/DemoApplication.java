package vn.techmaster.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private User user;

	@Autowired
	private Random random;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		user.work();
		System.out.println("Random Number = " + random.nextInt(1000));
	}
}

