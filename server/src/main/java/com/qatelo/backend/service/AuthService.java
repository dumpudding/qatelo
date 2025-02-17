package com.qatelo.backend.service;

import com.qatelo.backend.dto.api.UserDTO;
import com.qatelo.backend.dto.auth.AuthResponseDTO;
import com.qatelo.backend.dto.auth.RegisterDTO;
import com.qatelo.backend.model.Role;
import com.qatelo.backend.model.UserEntity;
import com.qatelo.backend.repository.RoleRepository;
import com.qatelo.backend.repository.UserRepository;
import com.qatelo.backend.security.jwt.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {
	private final AuthenticationManager manager;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserService userService;
	private final PasswordEncoder encoder;
	private final JWTTokenGenerator tokenGenerator;

	@Autowired
	public AuthService(AuthenticationManager manager,
					   UserRepository userRepository,
					   RoleRepository roleRepository,
					   UserService userService,
					   PasswordEncoder encoder,
					   JWTTokenGenerator tokenGenerator) {
		this.manager = manager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.tokenGenerator = tokenGenerator;
		this.userService = userService;
	}

	public ResponseEntity<String> createUser(RegisterDTO register) {
		if (userRepository.existsByUsername(register.getUsername()))
			return ResponseEntity.badRequest().body("Username is already taken");

		UserEntity user = new UserEntity();
		user.setUsername(register.getUsername());
		user.setPassword(encoder.encode(register.getPassword()));
		user.setVerified(false);

		Role role = roleRepository.findByName("USER").get();
		user.setRoles(Collections.singletonList(role));
		userService.initializeProfile(UserDTO.defaultProfile(), user);
		userRepository.save(user);
		return ResponseEntity.ok("Successfully created user");
	}

	public AuthResponseDTO login(String username, String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = manager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String tokenProvider = tokenGenerator.generateToken(auth);
		return new AuthResponseDTO(tokenProvider);
	}

	public ResponseEntity<String> changePassword(String oldPassword, String newPassword) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUsername = auth.getName();

		if (oldPassword.equals(newPassword))
			return ResponseEntity.badRequest().body("New password cannot  be the same as current password");

		UserEntity user = userRepository.findByUsername(currentUsername)
				.orElseThrow(() -> new UsernameNotFoundException("Could not change password. User not found"));

		if (!encoder.matches(oldPassword, user.getPassword()))
			return ResponseEntity.badRequest().build();

		user.setPassword(encoder.encode(newPassword));
		userRepository.save(user);
		return ResponseEntity.ok("Successfully changed password");
	}


}
