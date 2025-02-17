package com.qatelo.backend.service;

import com.qatelo.backend.dto.api.UserDTO;
import com.qatelo.backend.exception.UserNotFoundException;
import com.qatelo.backend.model.UserEntity;
import com.qatelo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void initializeProfile(UserDTO dto, UserEntity profile) {
		profile.setFirstName(dto.getFirstName());
		profile.setLastName(dto.getLastName());
		profile.setEmail(dto.getEmail());
		profile.setImageUrl(dto.getImageUrl());
		profile.setBiography(dto.getBiography());
		profile.setFaculty(dto.getFaculty());
	}

	public Optional<UserDTO> getProfile(long id) {
		return userRepository.findById(id).map(this::toUserDTO);
	}

	public Optional<UserDTO> getProfileByUsername(String username) {
		return userRepository.findByUsername(username).map(this::toUserDTO);
	}

	public List<UserDTO> searchProfile(String query, String searchType) {
		List<UserEntity> profiles = switch (searchType) {
			case "name" -> userRepository.findByName(query);
			case "username" -> userRepository.findByUsernameContainingIgnoreCase(query);
			case "email" -> userRepository.findByEmailContainingIgnoreCase(query);
			default -> throw new IllegalStateException("Unexpected value: " + searchType);
		};

		return profiles.stream()
				.map(this::toUserDTO)
				.toList();
	}

	public UserDTO updateProfile(long id, UserDTO dto) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Could not find profile to update"));

		if (dto.getFirstName() != null)
			user.setFirstName(dto.getFirstName());

		if (dto.getLastName() != null)
			user.setLastName(dto.getLastName());

		if (dto.getEmail() != null)
			user.setEmail(dto.getEmail());

		if (dto.getImageUrl() != null)
			user.setImageUrl(dto.getImageUrl());

		if (dto.getBiography() != null)
			user.setBiography(dto.getBiography());

		return toUserDTO(userRepository.save(user));
	}

	public void deleteProfile(long id) {
		userRepository.deleteById(id);
	}

	private UserDTO toUserDTO(UserEntity profile) {
		UserDTO dto = new UserDTO();
		dto.setFirstName(profile.getFirstName());
		dto.setLastName(profile.getLastName());
		dto.setEmail(profile.getEmail());
		dto.setImageUrl(profile.getImageUrl());
		dto.setBiography(profile.getBiography());
		dto.setFaculty(profile.getFaculty());
		return dto;
	}
}
