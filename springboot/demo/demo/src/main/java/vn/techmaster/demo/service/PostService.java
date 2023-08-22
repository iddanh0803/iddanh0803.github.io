package vn.techmaster.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demo.dao.PostDAO;
import vn.techmaster.demo.exception.BadRequestException;
import vn.techmaster.demo.exception.ResourceNotFoundException;
import vn.techmaster.demo.model.Post;

import java.util.List;
import java.util.Random;

@Service
public class PostService implements PostServiceImpl {
    @Autowired
    private PostDAO postDAO;


    @Override
    public List<Post> getAllPost(){
        return postDAO.findAll();
    }

    @Override
    public Post createPost(Post request) {
        Random rd = new Random();
        Post post = new Post();
        post.setId(rd.nextInt(1000));
        post.setAuthor(request.getAuthor());
        post.setTitle(request.getTitle());
        postDAO.save(post);
        return post;
    }

    @Override
    public Post getPostById(Integer id) {
        List<Post> postList = postDAO.findAll();
        return postList.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->{
                    throw new ResourceNotFoundException("Not found Post");
                });
    }

    @Override
    public Post updatePost(Integer id, Post request) {
        Post post = getPostById(id);
        post.setTitle(request.getTitle());
        post.setAuthor(request.getAuthor());
        return post;
    }

    @Override
    public void deletePost(Integer id) {
        Post post = getPostById(id);
        postDAO.delete(id);
    }

    @Override
    public List<Post> searchPost(String title) {
        if (title.trim().length()==0){
            throw new BadRequestException("Title không được để trống");
        }
        return postDAO.findByTitleContainsIgnoreCase(title);
    }
}
