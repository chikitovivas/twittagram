package services;

import com.example.twittagram.models.Post;
import com.example.twittagram.repository.PostRepository;
import com.example.twittagram.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceTest {

    private PostService postService;

    private PostRepository postRepository;

    private Map<String, List<Post>> userPosts;

    @BeforeEach
    void setUp() {
        userPosts = loadMap();
        this.postRepository = new PostRepository(userPosts);
        this.postService = new PostService(postRepository);
    }

    @Test
    public void testCreatePostSuccessfully() {
        String userId = "1";
        String title = "Hola2";
        String content = "Mundo2";

        Post post = postService.createPost(title, content, userId);

        assertNotNull(post);
        assertEquals(post.getUserId(), userId);
        assertEquals(post.getTitle(), title);
        assertEquals(post.getContent(), content);
    }

    @Test
    public void testCreatePostForFirstTimeSuccessfully() {
        String userId = "2";
        String title = "Primer";
        String content = "Post";

        Post post = postService.createPost(title, content, userId);

        assertNotNull(post);
        assertEquals(post.getUserId(), userId);
        assertEquals(post.getTitle(), title);
        assertEquals(post.getContent(), content);
    }

    private Map<String, List<Post>> loadMap(){
        String user1 = "1";
        Post post1 = new Post("Hola", "Mundo", user1);


        List<Post> user1List = new ArrayList<>();
        user1List.add(post1);

        Map<String, List<Post>> userPosts = new HashMap<>();
        userPosts.put(user1, user1List);

        return userPosts;
    }
}
