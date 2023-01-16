package me.whiteship.springdatademo2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setPost(this);
    }
}
