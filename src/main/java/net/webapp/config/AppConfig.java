package net.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@PropertySource("classpath:/net/webapp/config/app.properties")
public class AppConfig {
	@Autowired
	private Environment env;

	@Profile("!test")
	@Bean
	public UserDetailsManager userDetailsManager() {
		UserDetailsManager userDetailsManager = new UserDetailsManager() {

			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean userExists(String username) {
				// TODO Auto-generated method stub
				return false;
			}

			public void updateUser(UserDetails user) {
				// TODO Auto-generated method stub

			}

			public void deleteUser(String username) {
				// TODO Auto-generated method stub

			}

			public void createUser(UserDetails user) {
				// TODO Auto-generated method stub

			}

			public void changePassword(String oldPassword, String newPassword) {
				// TODO Auto-generated method stub

			}
		};
		return userDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}
}
