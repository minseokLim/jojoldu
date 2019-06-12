package com.jojoldu.webservice.domain.posts;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void saveAndLoad() {

        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("mslim@naver.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        Assert.assertEquals(posts.getTitle(), "테스트 게시글");
        Assert.assertEquals(posts.getContent(), "테스트 본문");
    }

    @Test
    public void baseTimeEntityTest() {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("mslim@naver.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        Assert.assertTrue(posts.getCreatedDate().isAfter(now));
        Assert.assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
