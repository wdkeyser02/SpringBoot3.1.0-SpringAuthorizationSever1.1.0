package willydekeyser.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {
		
		@GetMapping("/hello")
		Map<String, String> home(@AuthenticationPrincipal Jwt jwt) {
			return Map.of("home", "Home: " + jwt.getSubject());
		}

}
