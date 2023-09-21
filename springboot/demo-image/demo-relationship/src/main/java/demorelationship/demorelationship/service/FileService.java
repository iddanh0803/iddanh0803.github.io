package demorelationship.demorelationship.service;

import demorelationship.demorelationship.entity.FileServer;
import demorelationship.demorelationship.entity.User;
import demorelationship.demorelationship.repository.FileRepository;
import demorelationship.demorelationship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;
    public FileServer uploadFile(Integer userId, MultipartFile file) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id" + userId));

        FileServer fileServer = new FileServer();
        fileServer.setType(file.getContentType());
        fileServer.setData(file.getBytes());
        fileServer.setUser(user);
        fileRepository.save(fileServer);

        return fileServer;
    }

    public FileServer getFileById(Integer id){
        return fileRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("File not found" + id));
    }

    public  void deleteFile(Integer id){
        FileServer fileServer = getFileById(id);
        fileRepository.delete(fileServer);
    }
}
