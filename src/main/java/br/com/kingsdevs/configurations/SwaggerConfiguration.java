package br.com.kingsdevs.configurations;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.kingsdevs"))
				.paths(PathSelectors.ant("/**"))
				.build().apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		
		return new ApiInfo("API para Controle de Empresas e Funcionários", "Sistema Spring Boot API / 	Banco de Dados - PostGreSQL", 
											"Versão 1.0", "http://www.kingsdevs.com.br",	
				    new Contact("KINGS DEVELOPERS LTDA", 	"http://www.kingsdevs.com.br", "contato@kingsdevs.com.br"), 
				    						"Licença da API", "http://www.kingsdevs.com.br",	 Collections.emptyList());	
	}
	
}
