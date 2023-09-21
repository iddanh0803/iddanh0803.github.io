package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.Book;
import demorelationship.demorelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
