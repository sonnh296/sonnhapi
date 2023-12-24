package dev.sonnhapi.service;

import dev.sonnhapi.DAO.TagDAO;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.repository.PostRepository;
import dev.sonnhapi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag findById(int id){
        return tagRepository.findById(id);
    }
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }
    public Tag saveTag(TagDAO tagDAO){
        Tag tag = Tag.builder()
                .tagName(tagDAO.getTagName())
                .build();
        return tagRepository.save(tag);
    }
}
