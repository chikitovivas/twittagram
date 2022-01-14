package com.example.twittagram.repository;

import com.example.twittagram.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PostRepository {
    private Map<String, List<Post>> userPosts;

    public PostRepository(Map<String, List<Post>> userPosts) {
        this.userPosts = userPosts;
    }

    public Post save(Post post) {
        String userId = post.getUserId();

        List<Post> posts = getPosts(userId);
        posts.add(post);

        return post;
    }

    public List<Post> getPosts(String userId) {
        List<Post> posts = userPosts.get(userId);

        if(Objects.isNull(posts)) {
            posts =  new ArrayList<>();
            userPosts.put(userId, posts);
        }

        return posts;
    }
}
