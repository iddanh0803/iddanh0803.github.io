package demorelationship.demorelationship;

import demorelationship.demorelationship.entity.User;
import demorelationship.demorelationship.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoRelationshipApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Test
	void save_user() {
		User user = new User();
		user.setName("John");
		userRepository.save(user);
	}

}
