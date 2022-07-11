package com.gl.collegedebateevent.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.collegedebateevent.entity.User;
import com.gl.collegedebateevent.repository.UserRepository;
import com.gl.collegedebateevent.security.AppUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUserDetails(user);
	}

}
