package br.edu.ifpb.lids.presentation.control;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Teste {


	public static String token = "";
    @GetMapping("/entrar")	
	String publicRoute(@AuthenticationPrincipal OidcUser principal) {
		token = principal.getIdToken().getTokenValue();
		return principal.getIdToken().getTokenValue();
	}

	@GetMapping("/token")
	String publicRoute2(@AuthenticationPrincipal OidcUser principal) {
		return token;
	}
}
