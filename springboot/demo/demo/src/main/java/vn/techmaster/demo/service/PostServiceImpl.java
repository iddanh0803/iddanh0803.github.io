package vn.techmaster.demo.service;

import vn.techmaster.demo.model.Post;

import java.util.List;

public interface PostServiceImpl {
    List<Post> getAllPost();

    Post createPost(Post request);

    Post getPostById(Integer id);

    Post updatePost(Integer id, Post request);

    void deletePost(Integer id);

    List<Post> searchPost(String title);
}
