package vn.techmaster.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Post;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class JSONFileReader implements IFileReader{
    @Override
    public List<Post> readFile(String filePath) {
        //Xử lý đọc File
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            ClassPathResource resource = new ClassPathResource(filePath);
            InputStream dbAsStream = resource.getInputStream();
            
            //Convert tệp JSON thành đối tượng Post
            Post post = objectMapper.readValue(new File(""), Post.class);

        }catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
