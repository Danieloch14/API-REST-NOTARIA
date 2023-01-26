package ec.gob.cj.pesnot.notaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ApiRestNotariaApplication  extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(ApiRestNotariaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiRestNotariaApplication.class, args);
	}

}
