package br.edu.ifpb.lids.presentation.control;


<<<<<<< HEAD
=======
import java.io.IOException;

>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import jakarta.servlet.http.HttpServletResponse;

>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
@RestController
@RequestMapping("/api")
public class Teste {


	public static String token = "";
    @GetMapping("/entrar")	
<<<<<<< HEAD
	String publicRoute(@AuthenticationPrincipal OidcUser principal) {
		token = principal.getIdToken().getTokenValue();
		return principal.getIdToken().getTokenValue();
=======
	String publicRoute(@AuthenticationPrincipal OidcUser principal, HttpServletResponse response) throws IOException, InterruptedException {
		
		token = principal.getIdToken().getTokenValue();
		Thread.sleep(1000);
		response.sendRedirect("http://localhost:3000/"); 
		return token;
>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
	}

	@GetMapping("/token")
	String publicRoute2() {
		return token;
	}
}