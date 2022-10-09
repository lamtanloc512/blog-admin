package org.jdev.blog.app.services.impl;

import org.jdev.blog.app.dto.PostDto;
import org.jdev.blog.app.entity.Post;
import org.jdev.blog.app.repository.PostRepository;
import org.jdev.blog.app.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public void createPost(PostDto postDto) {
        try {
            String[] words = postDto.getTitle().toLowerCase().split(" ");
            String postSlug = String.join("-", words);
            log.info("slug: {}", postSlug);
            Post newPost = modelMapper.map(postDto, Post.class);
            postRepository.save(newPost);
        } catch (Exception e) {
            log.error("Exception occured when save new post: {}", e.getLocalizedMessage());
        }
	}

    @Override
    public PostDto getPostBySlug(String slug) {
        try {
            return modelMapper.map(postRepository.findBySlug(slug).orElseThrow(() -> new Exception("Post not found!")),
                    PostDto.class);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
}
