package org.jdev.blog.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private String type;
    private String content;
    private int code;
}
