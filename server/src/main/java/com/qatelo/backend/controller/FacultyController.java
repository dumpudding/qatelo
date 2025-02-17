package com.qatelo.backend.controller;

import com.qatelo.backend.dto.api.FacultyDTO;
import com.qatelo.backend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	private final FacultyService facultyService;

	@Autowired
	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@GetMapping
	public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
		return ResponseEntity.ok(facultyService.getAllFaculties());
	}

	@PostMapping("/search")
	public ResponseEntity<List<FacultyDTO>> getFaculies(@RequestBody FacultyDTO.Search searchDTO) {
		List<FacultyDTO> faculties = isSearchValid(searchDTO)
				? facultyService.searchFaculties(searchDTO.getSearch()) : Collections.emptyList();
		return ResponseEntity.ok(faculties);
	}

	private boolean isSearchValid(FacultyDTO.Search searchDTO) {
		return searchDTO.getSearch() != null && !searchDTO.getSearch().isEmpty();
	}
}
