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
		inMemoryUserList.add(new JwtUserDetails(1L, "user1",
				"$2a$10$YO4h7imOI7U9kzMT/U7laehZtUAsh6Q3NRc1aSFZM7L/YFsDY3Ngy", "ROLE_USER_1"));
		inMemoryUserList.add(new JwtUserDetails(2L, "user2",
				"$2a$10$iUQN.92pYsv5OCDW0NI6Rey00eSFcXdbAhRO3R75i3G13ZW6puEDu", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(3L, "user3",
				"$2a$10$XuDGpXAIeBF9sTg5i8UlvugnjsAh7ZDm9z0fb/WFWY8TQUQSHhofG", "ROLE_USER_3"));
	}

	/*
	 * Password 1
	 * $2a$10$YO4h7imOI7U9kzMT/U7laehZtUAsh6Q3NRc1aSFZM7L/YFsDY3Ngy
	 * $2a$10$qsnPQcr3wWGjZw3UhLulReArq08.U932J8NT4A8y2GHamf4qBe.5C
	 * $2a$10$xRpDpbM64TlYB/rLstYWGOVzvLOkHjrm0YVIYlEfrVa3aoW5gEsqO
	 */

	/*
	 * Password 2 $2a$10$iUQN.92pYsv5OCDW0NI6Rey00eSFcXdbAhRO3R75i3G13ZW6puEDu
	 * $2a$10$DXR//og0xkUaIITtjF0BX.Gfui.YP8Y96N7R4RU57SBEFRA0w22Ja
	 * $2a$10$6Zrd/IvlzHM0NTRw.PpYiuhbFe3ZS9wEBZhYaRDxJUawWMzGo7F/6
	 */

	/*
	 * Password 3
	 * $2a$10$OqAW/Qeyx.mpw48YstfjDuJZD8W9V7aejGlHutOQIEwIg8cQ/Bsym
	 * $2a$10$7nFRMA.rzaOcPM2xLPYgNONC0Nu8JxsoXeJ5T0uXxClemcFS1oMcS
	 * $2a$10$XuDGpXAIeBF9sTg5i8UlvugnjsAh7ZDm9z0fb/WFWY8TQUQSHhofG
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
