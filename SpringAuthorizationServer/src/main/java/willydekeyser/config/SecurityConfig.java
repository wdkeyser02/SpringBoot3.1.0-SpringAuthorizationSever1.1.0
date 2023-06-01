package willydekeyser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		var user1 = User.withUsername("user")
				.password("{noop}password")
				.roles("USER")
				.build();
		var user2 = User.withUsername("admin")
				.password("{noop}password")
				.roles("USER", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
}
