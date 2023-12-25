package dev.sonnhapi.service;

import dev.sonnhapi.DAO.CategoryDAO;
import dev.sonnhapi.DAO.TagDAO;
import dev.sonnhapi.entity.PostCategory;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.repository.CategoryRepository;
import dev.sonnhapi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public PostCategory findById(int id){
        return categoryRepository.findById(id);
    }
    public List<PostCategory> getAllCategories(){
        return categoryRepository.findAll();
    }
    public PostCategory saveCategory(CategoryDAO categoryDAO){
        PostCategory postCategory = PostCategory.builder()
                .categoryName(categoryDAO.getCategoryName())
                .build();
        return categoryRepository.save(postCategory);
    }
}
