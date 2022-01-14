package com.example.twittagram.services;

import com.example.twittagram.models.Post;
import com.example.twittagram.models.User;
import com.example.twittagram.repository.PostRepository;

import java.util.List;

public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(String title, String content, String userId) {
        Post post = new Post(title, content, userId);

        return postRepository.save(post);
    }


    public List<Post> getPosts(User user) {
        //Repository
        return postRepository.getPosts(user.getUserId());
    }
}
