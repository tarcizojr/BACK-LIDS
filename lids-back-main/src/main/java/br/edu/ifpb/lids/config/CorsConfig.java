package br.edu.ifpb.lids.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // Adicione a origem permitida aqui
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adicione os métodos HTTP permitidos aqui
                .allowedHeaders("*"); // Adicione os cabeçalhos permitidos aqui
    }
}
