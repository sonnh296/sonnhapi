package dev.sonnhapi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "priority")
    private int priority;
    @Column(name = "create_time")
    private String createTime;
    @ManyToMany
    @JoinTable(
            name = "Post_Tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> listTag;

    @ManyToOne
    @JoinColumn(name="post_category")
    private PostCategory postCategory;
}
