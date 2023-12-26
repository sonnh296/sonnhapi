package dev.sonnhapi.controller;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag Reader", description = "tag api for admin")
@RestController
@RequestMapping("/api/v1/reader/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> findPostsByTagName(){
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/id/{tagId}")
    public ResponseEntity<Tag> findById(@PathVariable int tagId){
        return ResponseEntity.ok(tagService.findById(tagId));
    }

}
