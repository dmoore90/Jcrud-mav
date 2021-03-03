package com.jcrud.Services;

import com.jcrud.Entities.Post;
import com.jcrud.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    //Read
    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    //Create
    public void save(Post post) {
        postRepository.save(post);
    }

    //Update
    public Post get(long id) {
        return postRepository.findById(id).get();
    }

    //Delete
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
