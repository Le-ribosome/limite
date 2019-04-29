package formation.Limite_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;

public class SpringApplication {

	public static void main(String[] args) {
		//Cr�er le contexte de SPRING
		AnnotationConfigApplicationContext heySpring = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Instancier une nouvelle classe qu'on va donner directement à Spring: 
		heySpring.getBeanFactory().createBean(Application.class).run(args);
		
		//Fermer le contexte de Spring: 
		heySpring.close();

	}

}