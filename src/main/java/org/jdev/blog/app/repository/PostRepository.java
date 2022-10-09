package org.jdev.blog.app.repository;

import java.util.Optional;

import org.jdev.blog.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findBySlug(String slug);
}
