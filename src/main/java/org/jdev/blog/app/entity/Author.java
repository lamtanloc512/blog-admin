package org.jdev.blog.app.entity;

import lombok.Data;

@Data
public class Author {
    private long id;
    private String name;
    private long appUserId;
}
