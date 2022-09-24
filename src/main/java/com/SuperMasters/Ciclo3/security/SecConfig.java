package com.SuperMasters.Ciclo3.security;

import com.SuperMasters.Ciclo3.handler.CustomHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomHandler customHandler;
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("select correo,password,status from empleado where correo=?")
				.authoritiesByUsernameQuery("select correo, rol from empleado where correo=?");
	}

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/empresas**").hasRole("ADMIN")
				.antMatchers("/empleados**").hasRole("ADMIN")
				.antMatchers("/","/index","/webpublico").authenticated()
				.antMatchers("/movimientos**").hasAnyRole("ADMIN","USER")
				.and()
				.formLogin().successHandler(customHandler)
				.loginPage("/login")
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/accessDenied")
				.and()
				.logout()
				.logoutUrl("/logout")
				.permitAll()
				.and()
				.csrf();
	}
}
