package com.tts.techtalentblog.repository;

import com.tts.techtalentblog.blogpost.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    @Override
    List<BlogPost> findAll();

}
