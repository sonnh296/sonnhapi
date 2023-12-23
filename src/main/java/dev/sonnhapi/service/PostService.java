package dev.sonnhapi.service;

import dev.sonnhapi.DAO.PostDAO;
import dev.sonnhapi.entity.Post;
import dev.sonnhapi.entity.PostCategory;
import dev.sonnhapi.entity.Tag;
import dev.sonnhapi.repository.CategoryRepository;
import dev.sonnhapi.repository.PostRepository;
import dev.sonnhapi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> findByTag(String tagName) {
        List<Post> unsortedPosts = postRepository.findByListTag_tagName(tagName);
        Collections.sort(unsortedPosts);
        return unsortedPosts;
    }

    public List<Post> findByCategoryId(int categoryId) {
        List<Post> unsortedPosts = postRepository.findByPostCategory_Id(categoryId);
        Collections.sort(unsortedPosts);
        return unsortedPosts;
    }

    public Post findByPostId(int postId) {
        return postRepository.findById(postId);
    }

    public Post savePost(PostDAO postDAO) {
        List<Tag> tags = new ArrayList<>();
        for (int tagId:postDAO.getListTag()) {
            tags.add(tagRepository.findById(tagId));
        }
        PostCategory postCategory = categoryRepository.findById(postDAO.getPostCategory());

        Post post = Post.builder()
                .title(postDAO.getTitle())
                .content(postDAO.getContent())
                .priority(postDAO.getPriority())
                .createTime(postDAO.getCreateTime())
                .listTag(tags)
                .postCategory(postCategory)
                .build();
        return postRepository.save(post);
    }

    public boolean deletePost(int postId) {
        Post post = postRepository.findById(postId);
        if (post != null) {
            postRepository.delete(post);
            return true;
        }
        return false;
    }
}
