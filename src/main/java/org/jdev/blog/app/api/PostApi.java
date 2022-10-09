package org.jdev.blog.app.api;

import org.jdev.blog.app.dto.Message;
import org.jdev.blog.app.dto.PostDto;

public interface PostApi {

    public Message createMessage(long userId, PostDto post);

}
