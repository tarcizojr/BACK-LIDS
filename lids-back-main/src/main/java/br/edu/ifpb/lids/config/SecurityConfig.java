package br.edu.ifpb.lids.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

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
              authorizeConfig.requestMatchers("/colaborador").permitAll();
              authorizeConfig.requestMatchers("/projeto/**").permitAll();
              authorizeConfig.anyRequest().authenticated();
            })
         .oauth2Login(Customizer.withDefaults())
         .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
        .build();
  }

}