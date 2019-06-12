package com.jojoldu.webservice.service;


import com.jojoldu.webservice.domain.posts.Posts;
import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void savePosts() {
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("mslim")
                .content("content")
                .title("title")
                .build();

        postsService.save(dto);

        Posts posts = postsRepository.findAll().get(0);
//        Assert.assertEquals(dto.getAuthor(), posts.getAuthor());
//        Assert.assertEquals(dto.getContent(), posts.getContent());
//        Assert.assertEquals(dto.getTitle(), posts.getTitle());
    }
}
