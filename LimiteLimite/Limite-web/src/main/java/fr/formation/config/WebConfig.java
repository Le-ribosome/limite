package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("fr.formation.controller")
@EnableWebMvc
public class WebConfig {
	
	//Pour g�rer les fichiers ressources en tant que tel:
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		}

	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	templateResolver.setPrefix("/WEB-INF/templates/");
	templateResolver.setSuffix(".html");
	return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	templateEngine.setTemplateResolver(templateResolver);
	templateEngine.setEnableSpringELCompiler(true);
	return templateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	viewResolver.setTemplateEngine(templateEngine);
	return viewResolver;
	}
	
//	//Configuration des views sous jsp 
//	@Bean
//	public UrlBasedViewResolver viewResolver() {
//	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//	viewResolver.setViewClass(JstlView.class);
//	viewResolver.setPrefix("/WEB-INF/views/");
//	viewResolver.setSuffix(".jsp");
//	return viewResolver;
//	}
	
}