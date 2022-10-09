package org.jdev.blog.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post.html")
public class PostController {
    
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("post");
    }

}
