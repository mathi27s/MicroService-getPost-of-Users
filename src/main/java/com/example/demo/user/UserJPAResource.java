package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private postRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> getOneId(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new userNotFoundExcecption("id-" + id);
		return user;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void delete(@PathVariable int id) {
		userRepository.deleteById(id);

	}

	@PostMapping("/jpa/users/")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User save = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<post> findAllUser(@PathVariable int id) {
		Optional<User> byId = userRepository.findById(id);
		if (!byId.isPresent())
			throw new userNotFoundExcecption("id - " + id);

		return byId.get().getPost();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody post postone, @PathVariable int id) {
		Optional<User> byId = userRepository.findById(id);
		if (!byId.isPresent())
			throw new userNotFoundExcecption("id - " + id);
		User user = byId.get();
		postone.setUser(user);
		post save = postRepository.save(postone);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}






//	@DeleteMapping("/jpa/users/{id}")
//	public void deleteUser(@PathVariable int id) {
//		userRepository.deleteById(id);
//	}
//
//
//	@PostMapping("/jpa/users")
//	public ResponseEntity<Object> createUser(@Valid @RequestBody User com.example.demo.user) {
//		User savedUser = userRepository.save(com.example.demo.user);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
//				.toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
}
