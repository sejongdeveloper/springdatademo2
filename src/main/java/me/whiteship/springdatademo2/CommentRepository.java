package me.whiteship.springdatademo2;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {

}
