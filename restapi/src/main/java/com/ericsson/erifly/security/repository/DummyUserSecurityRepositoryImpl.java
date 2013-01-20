/**
 * 
 */
package com.ericsson.erifly.security.repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ericsson.erifly.security.domain.RESTUser;

import java.util.ArrayList;

/**
 * @author Dhrubo
 *
 */
@Repository
public class DummyUserSecurityRepositoryImpl implements UserSecurityRepository{

	private RESTUser simulateFetchOfuser() {
        return new RESTUser("someapp", "api-pk-9999", "api-1234", new ArrayList<GrantedAuthority>());
    }

    public UserDetails getUserByUsername(String username) {
        RESTUser exampleUser = simulateFetchOfuser();

        if(username.equalsIgnoreCase(exampleUser.getUsername())){
            return exampleUser;
        }
        return null;
    }

    public UserDetails getUserByApiKey(String apiKey) {
        RESTUser exampleUser = simulateFetchOfuser();
        if(apiKey.equals(exampleUser.getApiKey())){
            return exampleUser;
        }
        return null;
    }

}
