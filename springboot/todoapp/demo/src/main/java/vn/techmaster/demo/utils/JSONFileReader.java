package vn.techmaster.demo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.techmaster.demo.model.Todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JSONFileReader implements IFileReader {

    @Override
    public List<Todo> readFile(String filePath) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            //Read the JSON file using java.nio.file.Path
            Path jsonFilePath = Paths.get(filePath);
            byte[] jsonData = Files.readAllBytes(jsonFilePath);

            //Convert JSON to List of Person objects
            List<Todo> todoList = objectMapper.readValue(jsonData, new TypeReference<List<Todo>>() {});

            return todoList;
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
