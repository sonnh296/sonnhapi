package dev.sonnhapi.controller;

import dev.sonnhapi.entity.PostCategory;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reader/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public ResponseEntity<List<PostCategory>> findCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/id/{categoryId}")
    public ResponseEntity<PostCategory> findById(@PathVariable int categoryId){
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }
}
