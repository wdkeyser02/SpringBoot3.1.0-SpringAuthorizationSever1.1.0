package willydekeyser.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import willydekeyser.service.HomeService;

@Controller
@ResponseBody
public class HomeController {

	private final HomeService homeService;

	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/hello")
	String home() {
		return "HELLO!";
	}
	
	@GetMapping("/user")
	Map<String, String> user() {
		return homeService.user();
	}
	
	@GetMapping("/admin")
	Map<String, String> admin() {
		return homeService.admin();
	}

}
