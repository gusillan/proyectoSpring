package com.pacoillan.configuracion;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInicializador implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// creamos el contexto
		AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
		// registramos los beans de Spring
		contexto.register(SpringConfigurador.class);
		// Ligamos el contexto o aplicación Web al configurador
		contexto.setServletContext(servletContext);
		// Carga dinámicamente el Servlet Controller de Spring
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(contexto));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
	}

	
}
