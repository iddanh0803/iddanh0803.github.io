package vn.techmaster.demo.utils;

import vn.techmaster.demo.model.Post;

import java.util.List;

public interface IFileReader {
    List<Post> readFile(String filePath);
}
