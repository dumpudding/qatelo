package com.qatelo.backend.service;

import com.qatelo.backend.dto.api.FacultyDTO;
import com.qatelo.backend.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FacultyService {

	public List<FacultyDTO> getAllFaculties() {
		return Arrays.stream(Faculty.values())
				.map(this::toFacultyDTO)
				.toList();
	}

	public List<FacultyDTO> searchFaculties(String query) {
		if (query == null || query.isEmpty()) {
			return Collections.emptyList();
		}

		String lowerCaseQuery = query.trim().toLowerCase();
		return Arrays.stream(Faculty.values())
				.filter(f -> f.getDisplayName().toLowerCase().contains(lowerCaseQuery))
				.map(this::toFacultyDTO)
				.toList();
	}

	private FacultyDTO toFacultyDTO(Faculty faculty) {
		FacultyDTO dto = new FacultyDTO();
		dto.setName(faculty.name());
		dto.setDisplayName(faculty.getDisplayName());
		return dto;
	}
}
