package vn.techmaster.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.demo.service.IFileService;

import java.io.File;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    private final IFileService fileService;

    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file){
        return ResponseEntity.ok(fileService.uploadFile(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readFile(@PathVariable String id){
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(fileService.readFile(id));
    }
}
