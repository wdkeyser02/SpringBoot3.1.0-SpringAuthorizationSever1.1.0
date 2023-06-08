package willydekeyser.controller;

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
	String user() {
		return homeService.user();
	}
	
	@GetMapping("/admin")
	String admin() {
		return homeService.admin();
	}

}
