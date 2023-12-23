package dev.sonnhapi.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sonnhapi.entity.PostCategory;
import dev.sonnhapi.entity.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDAO {

    private String title;
    private String content;
    private int priority;
    private String createTime;
    private List<Integer> listTag;

    private int postCategory;
}
