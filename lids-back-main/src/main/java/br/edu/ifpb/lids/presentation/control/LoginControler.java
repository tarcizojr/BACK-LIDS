package br.edu.ifpb.lids.presentation.control;


import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class LoginControler {


	public static String token = "";
    @GetMapping("/entrar")	
	String publicRoute(@AuthenticationPrincipal OidcUser principal, HttpServletResponse response) throws IOException, InterruptedException {
		
		token = principal.getIdToken().getTokenValue();
		Thread.sleep(1000);
		response.sendRedirect("http://localhost:3000/"); 
		return token;
	}

	@GetMapping("/token")
	String publicRoute2() {
		return token;
	}

	@GetMapping("/altenticado")
	boolean altenticado(){
		if(!token.equals("")){
			return true;
		}else{
			return false;
		}
	}
}