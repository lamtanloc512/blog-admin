package org.jdev.blog.app.repository;

import org.jdev.blog.app.entity._User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<_User, Long> {
}
