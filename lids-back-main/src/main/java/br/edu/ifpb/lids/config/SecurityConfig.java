package br.edu.ifpb.lids.config;


<<<<<<< HEAD
=======
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD
=======
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.core.Ordered;
>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            authorizeConfig -> {
              authorizeConfig.requestMatchers("/public").permitAll();
              authorizeConfig.requestMatchers("/logout").permitAll();
              authorizeConfig.requestMatchers("/entrar/**").permitAll();
<<<<<<< HEAD
=======
              authorizeConfig.requestMatchers("api/token").permitAll();

>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
              authorizeConfig.requestMatchers("/colaborador").permitAll();
              authorizeConfig.requestMatchers("/projeto/**").permitAll();
              authorizeConfig.anyRequest().authenticated();
            })
         .oauth2Login(Customizer.withDefaults())
         .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        .build();
  }

<<<<<<< HEAD
=======
  	@Bean
	  public FilterRegistrationBean<CorsFilter> corsFilter() {

		List<String> all = Arrays.asList("*");

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedMethods(all);
		corsConfiguration.setAllowedOriginPatterns(all);
		corsConfiguration.setAllowedHeaders(all);
		corsConfiguration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		CorsFilter corFilter = new CorsFilter(source);

		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(corFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return filter;
	}
>>>>>>> bcb8e1ac7003e58272067e4e584d028e47e37abb
}