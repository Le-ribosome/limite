package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:data-source.properties")
@EnableJpaRepositories("fr.formation.dao")
public class JpaConfig {

	@Autowired
	private Environment env;
	
	//Configuration de la bdd: avec un @bean pour qu'il soit géré par Spring
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//Propriété de connexion: 
		dataSource.setDriverClassName((env.getProperty("sql.drive")));
		dataSource.setUrl(env.getProperty("sql.url"));
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMaxTotal((env.getProperty("sql.maxTotal", Integer.class)));
		
		return dataSource;
	}
	
	
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "false");
		return properties;
		}
	
	
	//Configuration emf
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	emf.setDataSource(dataSource);
	emf.setPackagesToScan("fr.formation.cartes", "fr.formation.jeu", "fr.formation.joueur", "fr.formation.modeDeJeu");
	emf.setJpaVendorAdapter(vendorAdapter);
	emf.setJpaProperties(this.hibernateProperties());
	return emf;
	}
	

	// Configuration du gestionnaire de transaction: 
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
}
