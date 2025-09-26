package com.arpitorg.joblisting.repository;

import java.util.List;
import com.arpitorg.joblisting.model.Post;

public interface SearchRepo {
  public List<Post> findByText(String text);
}
