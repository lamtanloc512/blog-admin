package org.jdev.blog.app.api.impl;

import org.jdev.blog.app.api.PostApi;
import org.jdev.blog.app.dto.Message;
import org.jdev.blog.app.dto.PostDto;
import org.jdev.blog.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RequestMapping("/api")
@Slf4j
@RestController
public class PostApiImpl implements PostApi {

    @Autowired
    private PostService postService;

    @Override
    @PostMapping("/post")
    public Message createMessage(@RequestParam(name = "user", required = true) long _userId,
            @RequestBody PostDto postdDto) {
        log.info("post content: {}", postdDto.toString());
        String message;
        int code;
        try {
            postService.createPost(postdDto);
            message = "Created Post Successfully";
            code = 201;
        } catch (Exception e) {
            message = "Error";
            code = 500;
        }
        return Message.builder().type("Post").content(message).code(code).build();
    }

    @GetMapping("/post/{slug}")
    public ResponseEntity<Object> getSinglePost(@PathVariable String slug) {
        PostDto postDto = postService.getPostBySlug(slug);
        if (postDto != null) {
            return new ResponseEntity<>(postDto, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(
                Message.builder().type("Post").content("Post not found!").code(404).build(), HttpStatus.BAD_REQUEST);
    }

}
