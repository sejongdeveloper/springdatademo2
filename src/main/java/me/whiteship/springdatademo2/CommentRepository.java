package me.whiteship.springdatademo2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {
    @Query(value = "SELECT * FROM Comment AS c", nativeQuery = true)
    List<Comment> findByTitleContains(String keyword);

}
