package com.pacoillan.configuracion;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan("com.pacoillan")
@EnableTransactionManagement

public class SpringConfigurador implements ApplicationContextAware {

	private ApplicationContext contexto;

	// Creamos el EntityManagerFactory con la unidad de persistencia
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter adaptador = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(adaptador);
		em.setPersistenceUnitName("illan");
		return em;
	}

	// Asignamos un gestor transaccional
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	// Traductor de excepciones de persistencia
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTraslation() {

		return new PersistenceExceptionTranslationPostProcessor();

	}

	// Resolutor de vistas
	private ITemplateResolver templateResolver() {

		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(contexto);
		resolver.setPrefix("/WEB-INF/vistas/");
		resolver.setSuffix(".html");

		resolver.setCacheable(false);
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;

	}
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver; 
	}
	
	// Cargar motor de plantillas
	@Bean
	public ISpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;		
		
	}
	
	public void setApplicationContext(ApplicationContext contexto) throws BeansException {

		this.contexto = contexto;

	}

}
