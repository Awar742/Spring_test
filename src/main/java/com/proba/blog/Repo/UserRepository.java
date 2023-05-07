package com.proba.blog.Repo;

import com.proba.blog.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
}
