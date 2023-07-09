package br.edu.ifpb.lids.presentation.control;


import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class Teste {


	 public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.youtube.com"); 
    }

	public static String token = "";
    @GetMapping("/entrar")	
	String publicRoute(@AuthenticationPrincipal OidcUser principal, HttpServletResponse response) throws IOException {
		response.sendRedirect("http://localhost:3000/colaboradores"); 
		token = principal.getIdToken().getTokenValue();
		return principal.getIdToken().getTokenValue();
	}

	@GetMapping("/token")
	String publicRoute2() {
		return token;
	}
}
