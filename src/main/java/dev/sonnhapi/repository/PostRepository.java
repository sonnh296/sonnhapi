package dev.sonnhapi.repository;

import dev.sonnhapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByTitle(String title);

    List<Post> findByListTag_tagName(String tagName);

    List<Post> findByPostCategory_Id(int categoryId);
    Post findById(int postId);
}
