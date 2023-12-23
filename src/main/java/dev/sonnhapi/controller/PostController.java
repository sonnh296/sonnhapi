package dev.sonnhapi.controller;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{tagName}")
    public ResponseEntity<List<Post>> findPostsByTagName(@PathVariable String tagName){
        return ResponseEntity.ok(postService.findByTag(tagName));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Post>> findPostsByCategory(@PathVariable String category){
        return ResponseEntity.ok(postService.findByCategory(category));
    }
}
