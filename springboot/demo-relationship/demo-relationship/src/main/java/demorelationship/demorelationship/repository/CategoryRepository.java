package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
