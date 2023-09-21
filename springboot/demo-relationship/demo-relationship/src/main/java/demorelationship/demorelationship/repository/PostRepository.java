package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
