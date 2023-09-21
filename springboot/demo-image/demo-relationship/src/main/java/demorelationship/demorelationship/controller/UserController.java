package demorelationship.demorelationship.controller;

import demorelationship.demorelationship.entity.FileServer;
import demorelationship.demorelationship.entity.User;
import demorelationship.demorelationship.repository.FileRepository;
import demorelationship.demorelationship.repository.UserRepository;
import demorelationship.demorelationship.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public class UserController {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    // API trả về HTML
    @GetMapping("/")
    public String getUserPage(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        // Code logic
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        List<FileServer> fileServerList = fileRepository.findByUser_IdOrderByCreatedAtDesc(id);
        model.addAttribute("files", fileServerList);
        // Code logic
        return "file";
    }

    // API trả về JSON
    @PostMapping("/api/users/{id}/files")
    public ResponseEntity<?> uploadFile(@PathVariable Integer id, @RequestParam("file")MultipartFile file) throws IOException {

        return ResponseEntity.ok(fileService.uploadFile(id,file));
    }

}
