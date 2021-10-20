package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = userDaoService.getUserByID(id);
		if(user == null) {
			throw new UserNotFoundException(String.format("User ID - %d Not Found", id));
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User out = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(out.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userDaoService.deleteUserByID(id);
		if(user == null) {
			throw new UserNotFoundException(String.format("User ID - %d Not Found", id));
		}
	}
}
