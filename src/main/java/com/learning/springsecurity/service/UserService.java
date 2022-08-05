package com.learning.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.springsecurity.model.AuthUser;
import com.learning.springsecurity.model.User;
import com.learning.springsecurity.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("going to get user :" + username);
		Optional<User> user = repo.findByUserName(username);
		System.out.println("user.isPresent :" + user.isPresent());
		
		

		user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));

		return user.map(AuthUser::new).get();
	}

}
