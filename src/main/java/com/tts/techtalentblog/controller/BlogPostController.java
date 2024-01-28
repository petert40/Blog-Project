package com.tts.techtalentblog.controller;

import com.tts.techtalentblog.blogpost.BlogPost;
import com.tts.techtalentblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping(path="/")
//    @ResponseBody
    public String index(Model model){
        List<BlogPost> posts = blogPostRepository.findAll();

        model.addAttribute("posts", posts);
        return "blogpost/index";
    }

    @GetMapping("/blogposts/new")
    public String newBlog(Model model){
        BlogPost blogPost = new BlogPost();
        model.addAttribute("blogPost",blogPost);
        return "blogpost/new";

    }

    @PostMapping(path="/blogposts")
    public String addNeweBlogPost(BlogPost blogPost, Model model){
        BlogPost savedPost = blogPostRepository.save(blogPost);
        model.addAttribute("title",blogPost.getTitle());
        model.addAttribute("author",blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }

}
