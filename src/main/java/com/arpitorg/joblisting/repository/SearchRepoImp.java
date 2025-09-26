package com.arpitorg.joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.arpitorg.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepoImp implements SearchRepo {

  @Autowired
  MongoClient client;

  @Autowired
  MongoConverter converter;

  @Override
  public List<Post> findByText(String text) {

    // search code copied from mongodb atlas aggregation pipeline
    MongoDatabase database = client.getDatabase("teluskoTut");
    MongoCollection<Document> collection = database.getCollection("joblisting");
    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
        new Document("$search",
            new Document("index", "default").append("text",
                new Document("query", text).append("path", Arrays.asList("profile", "desc", "techs")))),
        new Document("$sort", new Document("exp", -1L)),
        new Document("$limit", 2L)));

    List<Post> rs = new ArrayList<>();

    result.forEach(doc -> rs.add(converter.read(Post.class, doc)));

    return rs;
  }

}
