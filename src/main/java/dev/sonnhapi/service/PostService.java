package dev.sonnhapi.service;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findByTag(String tagName){
        return postRepository.findByListTag_tagName(tagName);
    }
}
