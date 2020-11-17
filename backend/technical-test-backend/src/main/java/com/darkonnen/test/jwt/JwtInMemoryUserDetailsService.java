package com.darkonnen.test.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
	}

	/*
	 * $2a$10$cEdGIgJVQTNnZ7YQqi7osOM7VEktMUk63BCxTt1m4u15O1HlHBYO2
	 * $2a$10$Ohq9.k02Hm5GCGywGsJqDuGqhHKA9PPhXWDTt2B56eURP1ykRHU3C
	 * $2a$10$jYV8eomKf.R6XPLJGsrJSOYHk9hOJOBGwqnbMKinDkUTFz.OBZ5ea
	 * $2a$10$M.sFixuptxQYNfqffVT/.eljG1s/.pvE1A/jdE6hZqs4.qazbEdMG
	 * $2a$10$s.FXmSCmEKCifnXjpjYG9eVPAFOZ3UqraQZB/NYZY1PkZp4kRMVZ.
	 * $2a$10$tKmg.VM3H29UjPd8kR2Rc.8auHu.gVdVv9jyj7pT6bWfOBfffENMy
	 * $2a$10$DG7gPBblJV0K1uj0wdSUYen4bpM4Y2UfaI18aadcelq9VmtgONOXC
	 * $2a$10$8q8Lzjl9xNSdi5PHlJ2UTe2ToqxGz1eZtfrOV7PWt0oaeLG/SLrMi
	 * $2a$10$AzR/F1DBOiYHXYHP6V5HfOmlF/KgJmEaVIwIKB8KRCb1MUiXO8W7y
	 * $2a$10$XoUs1oVToQJUUXiRsSMMoeYcztTbBz/iARa5b38f71CAEnmwRvMwW
	 * $2a$10$3QpFiN.FHaayxDbb6/r7P.yaISqsmNWPhHGHcJPblefMV3vKK35CS
	 * 
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
