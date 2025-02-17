package com.qatelo.backend.dto.api;

import com.qatelo.backend.model.Faculty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FacultyDTO {
	private String name;
	private String displayName;

	@Data
	public static class Search {
		@NotBlank(message = "Search term cannot be blank")
		private String search;
	}

	public Faculty faculty(String facultyName) {
		return Faculty.valueOf(facultyName);
	}
}
