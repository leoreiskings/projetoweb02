package br.com.kingsdevs.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.kingsdevs.security.JwtSecurity;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class JwtConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//NESTE ENDPOINT TUDO ESTARÁ RESTRITO CASO NAO ESTEJA AUTENTICADO. NÃO HAVERÁ NADA PERMITIDO.
		//TUDO DEVERÁ ESTAR AUTENTICADO
		http.csrf().disable()
							.addFilterAfter(new JwtSecurity(), UsernamePasswordAuthenticationFilter.class)
							.authorizeRequests()
							.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.anyRequest()
							.authenticated();
	}

	private static final String[] SWAGGER = { 
			"/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui", 
			"/configuration/security", "/swagger-ui.html", "/webjars/**", 
			"/v3/api-docs/**", "/swagger-ui/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(SWAGGER);
	}
}
