package vn.techmaster.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String uploadFile(MultipartFile file);

    byte[] readFile(String id);
}
