package dev.sonnhapi.service;

import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.repository.PostRepository;
import dev.sonnhapi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag findById(int id){
        return tagRepository.findById(id);
    }
}
