package dev.sonnhapi.repository;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findById(int id);
}
