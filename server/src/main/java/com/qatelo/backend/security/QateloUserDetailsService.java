package com.qatelo.backend.security;

import com.qatelo.backend.model.Role;
import com.qatelo.backend.model.UserEntity;
import com.qatelo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QateloUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public QateloUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));

		return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private List<SimpleGrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.toList();
	}
}
