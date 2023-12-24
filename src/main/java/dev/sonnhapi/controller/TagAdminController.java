package dev.sonnhapi.controller;

import dev.sonnhapi.DAO.PostDAO;
import dev.sonnhapi.DAO.TagDAO;
import dev.sonnhapi.entity.Post;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tag")
@RequiredArgsConstructor
public class TagAdminController {
    private final TagService tagService;

    @PostMapping("/save")
    public ResponseEntity<Tag> savePost(@RequestBody TagDAO tagDAO){
        return new ResponseEntity<>(tagService.saveTag(tagDAO), HttpStatus.CREATED);
    }
}
