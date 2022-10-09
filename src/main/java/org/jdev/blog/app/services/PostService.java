package org.jdev.blog.app.services;

import org.jdev.blog.app.dto.PostDto;

public interface PostService {
    
    void createPost(PostDto postDto);

    PostDto getPostBySlug(String slug);

}
