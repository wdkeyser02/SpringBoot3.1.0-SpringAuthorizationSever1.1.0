package willydekeyser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/fallback")
	String getFallback() {
		System.err.println("FALLBACK");
		return "Fallback";
	}
}
