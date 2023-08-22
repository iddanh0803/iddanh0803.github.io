package vn.techmaster.demo.dao;

import vn.techmaster.demo.model.Post;

import java.util.List;

public interface PostDAOimpl {
    List<Post> findAll();

    void save(Post post);

    void delete(Integer id);

    List<Post> findByTitleContainsIgnoreCase(String title);
}
