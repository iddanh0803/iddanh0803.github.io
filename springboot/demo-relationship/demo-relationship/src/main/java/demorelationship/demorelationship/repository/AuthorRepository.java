package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.Author;
import demorelationship.demorelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
