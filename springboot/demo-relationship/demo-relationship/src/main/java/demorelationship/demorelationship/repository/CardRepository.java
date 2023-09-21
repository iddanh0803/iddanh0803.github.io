package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.Card;
import demorelationship.demorelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {


}
