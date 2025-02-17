package com.qatelo.backend.controller;

import com.qatelo.backend.dto.auth.AuthResponseDTO;
import com.qatelo.backend.dto.auth.ChangePasswordDTO;
import com.qatelo.backend.dto.auth.LoginDTO;
import com.qatelo.backend.dto.auth.RegisterDTO;
import com.qatelo.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO register) {
		return authService.createUser(register);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> changePassword(@Valid @RequestBody LoginDTO login) {
		return ResponseEntity.ok().body(authService
				.login(login.getUsername(), login.getPassword()));
	}

	@PostMapping("/change-password")
	public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordDTO request) {
		return authService.changePassword(request.getOldPassword(), request.getNewPassword());
	}
}
