package com.proba.blog.Repo;

import com.proba.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> getByType(String type);
}


