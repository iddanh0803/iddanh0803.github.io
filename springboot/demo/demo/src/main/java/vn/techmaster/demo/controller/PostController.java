package vn.techmaster.demo.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demo.model.Post;
import vn.techmaster.demo.response.ErrorReponse;
import vn.techmaster.demo.service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Controller
//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {
    @Autowired
    private PostService postService;

    // 1. Lấy danh sách tất cả post
    @GetMapping("")
    public ResponseEntity<?> getAllPost(){
        return ResponseEntity.ok(postService.getAllPost());
    }
//    public List<Post> getAllPost(){
//        return postService.getAllPost();
//    }

    // 2. Lấy post theo id
    @GetMapping( "{id}")

    public ResponseEntity<?> getPostById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(postService.getPostById(id));
        }catch (RuntimeException e){
            return new ResponseEntity<>(
                    new ErrorReponse(HttpStatus.NOT_FOUND, e.getMessage()),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    // 3. Tạo mới
    @PostMapping("")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post request){
        try {
            return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED) ;
        }catch (RuntimeException e){
            return new ResponseEntity<>(
                    new ErrorReponse(HttpStatus.NOT_FOUND, e.getMessage()),
                    HttpStatus.NOT_FOUND
            );
        }

    }

    // 4. Cập nhật
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Integer id,@Valid @RequestBody Post request){

        return postService.updatePost(id,request);
    }

    // 5. Xóa
    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Integer id){
       postService.deletePost(id);
    }

    // 6. Tìm kiếm
    // /posts/search?title=bac
    @GetMapping("search")
    public List<Post> searchPost(@RequestParam(required = false) String title){
        return postService.searchPost(title);
    }
}
