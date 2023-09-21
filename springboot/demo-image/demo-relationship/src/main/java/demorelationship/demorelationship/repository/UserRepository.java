package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
