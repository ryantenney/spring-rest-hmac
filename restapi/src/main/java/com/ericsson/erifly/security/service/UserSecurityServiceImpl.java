/**
 * 
 */
package com.ericsson.erifly.security.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ericsson.erifly.security.repository.UserSecurityRepository;

/**
 * @author Dhrubo
 * 
 */
@Named
public class UserSecurityServiceImpl implements UserSecurityService {

	@Inject
	private UserSecurityRepository userSecurityRepository;

	public UserDetails loadUserByUsername(String s)
			throws UsernameNotFoundException {
		UserDetails userDetails = userSecurityRepository.getUserByUsername(s);
		if (userDetails == null) {
			throw new UsernameNotFoundException(
					"User not found using supplied username");
		}

		return userDetails;
	}

	
	public UserDetails getUserByApiKey(String apiKey) {
		UserDetails userDetails = userSecurityRepository
				.getUserByApiKey(apiKey);
		if (userDetails == null) {
			throw new UserNotFoundException(
					"User could not be found with the supplied api key.");
		}

		return userDetails;
	}
}
