package demorelationship.demorelationship.controller;

import demorelationship.demorelationship.entity.FileServer;
import demorelationship.demorelationship.repository.FileRepository;
import demorelationship.demorelationship.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    // 2. Xem file
    @GetMapping("api/v1/files/{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        FileServer fileServer = fileService.getFileById(id);
        // Code logic
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileServer.getType()))
                .body(fileServer.getData());
    }

    // 3. Xoa file
    @DeleteMapping("api/v1/files/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        fileService.deleteFile(id);
        // Code logic
        return ResponseEntity.noContent().build(); // 204
    }

}
