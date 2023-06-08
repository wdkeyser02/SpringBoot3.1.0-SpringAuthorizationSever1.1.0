package willydekeyser.controller;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Controller
public class AuthorizationController {
	
	private final WebClient webClient;
	private final String messagesBaseUri;

	public AuthorizationController(WebClient webClient, @Value("${messages.base-uri}") String messagesBaseUri) {
		this.webClient = webClient;
		this.messagesBaseUri = messagesBaseUri;
	}

	@GetMapping(value = "/user")
	public String user(Model model, @RegisteredOAuth2AuthorizedClient("springoauthclient") OAuth2AuthorizedClient authorizedClient) {

		String messages = this.webClient
				.get()
				.uri(this.messagesBaseUri + "/user")
				.attributes(oauth2AuthorizedClient(authorizedClient))
				.retrieve()
				.bodyToMono(String.class)
				.block();
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/admin")
	public String admin(Model model, @RegisteredOAuth2AuthorizedClient("springoauthclient") OAuth2AuthorizedClient authorizedClient) {

		String messages = this.webClient
				.get()
				.uri(this.messagesBaseUri + "/admin")
				.attributes(oauth2AuthorizedClient(authorizedClient))
				.retrieve()
				.bodyToMono(String.class)
				.block();
		model.addAttribute("messages", messages);
		return "index";
	}

	@ExceptionHandler(WebClientResponseException.class)
	public String handleError(Model model, WebClientResponseException ex) {
		model.addAttribute("error", ex.getMessage());
		return "index";
	}
}