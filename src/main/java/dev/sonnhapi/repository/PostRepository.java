package dev.sonnhapi.repository;

import dev.sonnhapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    Post findByTitle(String title);

    //@Query("SELECT u FROM User u WHERE u.status = 1")
    List<Post> findByListTag_tagName(String tagName);
}
