package com.arpitorg.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arpitorg.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
