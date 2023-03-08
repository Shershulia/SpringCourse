package com.ntnu.ivansh.Building.Restful.Api.jpa;

import com.ntnu.ivansh.Building.Restful.Api.Users.Post;
import com.ntnu.ivansh.Building.Restful.Api.Users.User;
import com.ntnu.ivansh.Building.Restful.Api.Users.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerJPA {

    private UserRepository userDaoService;
    private PostRepository postRepository;


    public UserControllerJPA(UserRepository userDaoService, PostRepository postRepository) {
        this.userDaoService = userDaoService;
        this.postRepository=postRepository;
    }
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }
    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id){
        Optional<User> user = userDaoService.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }else{
            EntityModel<User> userEntityModel = EntityModel.of(user.get()); //wrapper to add links to class
//            WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass(),retrieveAllUsers()));
//            userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));
            return userEntityModel;}
    }
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userDaoService.deleteById(id);
    }
    @GetMapping(path = "/users/{id}/posts")
    public List<Post> retrievePostsFromUser(@PathVariable int id){
        Optional<User> user = userDaoService.findById(id);
        return user.get().getPosts();
    }
    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = userDaoService.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
