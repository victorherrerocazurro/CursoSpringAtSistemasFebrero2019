package com.curso.spring.webseguro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	// Autorizacion y proceso de autenticacion
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Autorizacion
		http.authorizeRequests().antMatchers("/saludar/**").hasRole("USER")

				// proceso de autenticacion
				.and().httpBasic();// formLogin();
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	// Almacen de usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER").disabled(false).and()
			.withUser("monitor").password("password").roles("ENDPOINT_ADMIN").disabled(false).and()
			.withUser("admin").password("password").roles("ADMIN", "USER").disabled(false);
		
	}

}
