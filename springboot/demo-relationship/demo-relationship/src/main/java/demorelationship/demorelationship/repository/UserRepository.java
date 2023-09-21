package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
}
