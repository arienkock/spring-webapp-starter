package net.webapp.config;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@PropertySource("classpath:/app.properties")
public class AppConfig {
	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	@Autowired
	private Environment env;

	@Profile("!test")
	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetailsManager userDetailsManager = new UserDetailsManager() {
			PasswordEncoder encoder = passwordEncoder();

			@SuppressWarnings("unchecked")
			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				return new User(username, encoder.encode(username),
						Collections.EMPTY_SET);
			}

			public boolean userExists(String username) {
				return true;
			}

			public void updateUser(UserDetails user) {
			}

			public void deleteUser(String username) {
			}

			public void createUser(UserDetails user) {
			}

			public void changePassword(String oldPassword, String newPassword) {
			}
		};
		return userDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}
}
