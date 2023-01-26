package ec.gob.cj.pesnot.notaria;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = "ec.gob.cj.pesnot")
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class ApiRestNotariaApplication  extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(ApiRestNotariaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiRestNotariaApplication.class, args);
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException{
	    super.onStartup(servletContext);
	    
	}

}
