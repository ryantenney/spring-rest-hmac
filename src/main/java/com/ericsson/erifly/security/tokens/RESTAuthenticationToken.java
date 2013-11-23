/**
 * 
 */
package com.ericsson.erifly.security.tokens;

/**
 * @author Dhrubo
 *
 */

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class RESTAuthenticationToken extends UsernamePasswordAuthenticationToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RESTAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public RESTAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
