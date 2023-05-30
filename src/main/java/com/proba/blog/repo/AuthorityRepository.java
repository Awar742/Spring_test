package com.proba.blog.repo;

import com.proba.blog.models.Authorities;
import com.proba.blog.models.AuthorityId;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authorities, AuthorityId> {

}
