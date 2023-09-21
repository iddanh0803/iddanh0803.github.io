package demorelationship.demorelationship.repository;

import demorelationship.demorelationship.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileServer, Integer> {
    List<FileServer> findByUser_IdOrderByCreatedAtDesc(Integer userid);
}
