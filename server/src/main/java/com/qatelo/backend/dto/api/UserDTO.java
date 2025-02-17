package com.qatelo.backend.dto.api;

import com.qatelo.backend.model.Faculty;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
	private String email;
	private String firstName;
	private String lastName;
	private Faculty faculty;
	private String imageUrl;
	private String biography;

	@Data
	public static class Search {
		private String query;
		private String searchType;

		public boolean isValid() {
			List<String> searchTypes = List.of("name", "username", "email");
			return searchType != null && searchTypes.contains(searchType.toLowerCase().trim());
		}
	}

	public static UserDTO defaultProfile() {
		UserDTO profile = new UserDTO();
		profile.setFirstName("");
		profile.setLastName("");
		profile.setEmail("");
		profile.setFaculty(Faculty.NONE);
		profile.setImageUrl("");
		profile.setBiography("");
		return profile;
	}

}
