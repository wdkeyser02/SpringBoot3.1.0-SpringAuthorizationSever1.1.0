package willydekeyser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(Model model, Authentication authentication) {
		model.addAttribute("login", authentication);
		return "index";
	}

	@GetMapping("/logged-out")
	public String loggedOut(Model model, Authentication authentication) {
		model.addAttribute("login", authentication);
		return "index";
	}

}