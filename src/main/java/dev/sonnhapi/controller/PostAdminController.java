package dev.sonnhapi.controller;

import dev.sonnhapi.DAO.PostDAO;
import dev.sonnhapi.entity.Post;
import dev.sonnhapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class PostAdminController {
    private final PostService postService;

    @GetMapping("/tag/{tagName}")
    public ResponseEntity<List<Post>> findPostsByTagName(@PathVariable String tagName){
        return ResponseEntity.ok(postService.findByTag(tagName));
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> findPostsById(@PathVariable int postId){
        return ResponseEntity.ok(postService.findByPostId(postId));
    }
    @PostMapping("/post")
    public ResponseEntity<Post> savePost(@RequestBody PostDAO post){
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }
    @PostMapping("/post/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable int postId){
        return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
    }
}
