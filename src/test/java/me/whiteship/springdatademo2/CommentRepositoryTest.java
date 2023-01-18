package me.whiteship.springdatademo2;

import org.assertj.core.internal.Futures;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        createCommnet(100, "spring data jpa");
        createCommnet(55, "HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));

        ListenableFuture<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("===========");
        System.out.println("is done?" + future.isDone());

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(List<Comment> comments) {
                System.out.println("==================");
                comments.forEach(System.out::println);
            }
        });
    }

    private void createCommnet(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }
}
