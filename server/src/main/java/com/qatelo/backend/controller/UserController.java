package com.qatelo.backend.controller;

import com.qatelo.backend.dto.api.UserDTO;
import com.qatelo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/id/{id}")
	public ResponseEntity<UserDTO> getProfileById(@PathVariable long id) {
		return userService.getProfile(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/username/{id}")
	public ResponseEntity<UserDTO> getProfileByUsername(@PathVariable String username) {
		return userService.getProfileByUsername(username)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateProfile(@PathVariable long id, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateProfile(id, userDTO));
	}

	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteProfile(@PathVariable long id) {
		userService.deleteProfile(id);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/search")
	public ResponseEntity<?> searchProfile(@RequestBody UserDTO.Search query) {
		if (!query.isValid())
			return ResponseEntity.badRequest().body("Invalid search type: '" + query.getSearchType() + "'");

		return ResponseEntity.ok(userService.searchProfile(query.getQuery(), query.getSearchType()));
	}
}
