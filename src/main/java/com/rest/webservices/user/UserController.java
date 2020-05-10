package com.rest.webservices.user;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.rest.webservices.exception.UserNotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

//    @GetMapping("/users/{id}")
//    public EntityModel<User> findById(@PathVariable int id) {
//        User user = service.findOne(id);
//        if(user == null) {
//            throw new UserNotFoundException("id -" + id);
//        }
//        EntityModel<User> resource = new EntityModel<>(user);
//        WebMvcLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        resource.add(linkTo.withRel("all-users"));
//        return resource;
//    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id -" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

}
