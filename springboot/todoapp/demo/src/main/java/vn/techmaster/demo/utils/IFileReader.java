package vn.techmaster.demo.utils;

import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Todo;

import java.util.List;

@Component
public interface IFileReader {
    List<Todo> readFile(String filePath);
}
