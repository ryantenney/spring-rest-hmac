/**
 * 
 */
package com.ericsson.erifly.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Dhrubo
 *
 */
public interface UserSecurityService extends UserDetailsService {

    UserDetails getUserByApiKey(String apiKey);
}
