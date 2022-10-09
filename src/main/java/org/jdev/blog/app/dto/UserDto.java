package org.jdev.blog.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private long id;
    private String username;
    private String email;
    private String password;
    // private List<Long> roles;
}
