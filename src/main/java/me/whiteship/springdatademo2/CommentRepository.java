package me.whiteship.springdatademo2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface CommentRepository extends MyRepository<Comment, Long> {
    @Async
    Future<List<Comment>> findByCommentContainsIgnoreCase(String comment, Pageable pageable);

}
