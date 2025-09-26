package com.arpitorg.joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpitorg.joblisting.model.Post;
import com.arpitorg.joblisting.repository.PostRepository;
import com.arpitorg.joblisting.repository.SearchRepo;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PostController {

  @Autowired
  PostRepository repo;

  @Autowired
  SearchRepo srchrepo;

  @Hidden // not include this controller or method in Swagger UI.
  @RequestMapping("/")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return repo.findAll();
  }

  @GetMapping("/post/{text}")
  public List<Post> search(@PathVariable String text) {
    return srchrepo.findByText(text);
  }

  @PostMapping("/post")
  public Post addPost(@RequestBody Post p) {
    return repo.save(p);
  }

}
