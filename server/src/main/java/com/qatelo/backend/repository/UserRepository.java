package com.qatelo.backend.repository;

import com.qatelo.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	// For internal shit
	Optional<UserEntity> findByUsername(String username);

	boolean existsByUsername(String username);

	// For search
	@Query("SELECT u FROM UserEntity u WHERE lower(concat(u.firstName, ' ', u.lastName)) LIKE lower(concat('%', :name, '%'))")
	List<UserEntity> findByName(String search);

	List<UserEntity> findByUsernameContainingIgnoreCase(String username);

	List<UserEntity> findByEmailContainingIgnoreCase(String email);
}
