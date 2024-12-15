package com.example.transactionsample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactionsample.entity.User;

@RestController
@RequestMapping("/api/users")
public class PostPutController { // PostMapping-creating a user using PathVariable and passing data through body

	private Map<Long, User> userMap = new HashMap<>();

	@PostMapping("/{id}")
	public ResponseEntity<String> adduser(@PathVariable("id") Long id, @RequestBody User user) {
		user.setId(id);
		userMap.put(id, user); // Inserted User to the map
		return ResponseEntity.ok("User created with id:" + id + "\n Firstname" + user.getFirstName() + "\nLastname:"
				+ user.getLastName());

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		if (!userMap.containsKey(id)) {

			return ResponseEntity.status(404).body("User Not Found");
		}

		User toUpdate = userMap.get(id);
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());

		return ResponseEntity.ok("User " + id + " updated" + "\nFirstName:" + toUpdate.getFirstName() + "\nLastName:"
				+ toUpdate.getLastName());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") Long id) {
		
		Map<String, String> result = new HashMap<>();
	
		if (!userMap.containsKey(id)) {
			result.put("error", "User Not Found");
			return ResponseEntity.status(404).body(result);
		}

		userMap.remove(id);

		result.put("status", "ok");
		return ResponseEntity.ok(result);

	}
}
