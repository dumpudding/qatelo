package com.qatelo.backend.controller;

import com.qatelo.backend.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

	@PostMapping("user/new")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> newUser(@RequestBody User user) {
		System.out.println(user.getEmail());
		System.out.println(user.getPasswordHash());
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
