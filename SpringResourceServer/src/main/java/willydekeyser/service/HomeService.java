package willydekeyser.service;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	@PreAuthorize("hasAuthority('SCOPE_user.read')")
	public Map<String, String> home() {
		var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Map.of("home", "Home: " + jwt.getSubject());
	}
	
	@PreAuthorize("hasRole('USER')")
	public Map<String, String> user() {
		var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Map.of("home", "USER: " + jwt.getSubject());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, String> admin() {
		var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Map.of("home", "ADMIN: " + jwt.getSubject());
	}
}
