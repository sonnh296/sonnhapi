package dev.sonnhapi.repository;

import dev.sonnhapi.entity.Post;
import dev.sonnhapi.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<PostCategory, Integer> {
    PostCategory findById(int id);
}
