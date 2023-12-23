package dev.sonnhapi.service;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findByTag(String tagName){
        List<Post> unsortedPosts = postRepository.findByListTag_tagName(tagName);
        Collections.sort(unsortedPosts);
        return  unsortedPosts;
    }

    public List<Post> findByCategory(String category){
        List<Post> unsortedPosts = postRepository.findByPostCategory_CategoryName(category);
        Collections.sort(unsortedPosts);
        return  unsortedPosts;
    }
}
