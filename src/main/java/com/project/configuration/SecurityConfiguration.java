package com.project.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED FROM user WHERE USERNAME = ?")
		.authoritiesByUsernameQuery("SELECT USERNAME, ROLE FROM user WHERE USERNAME = ?");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()	
		.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.and().authorizeRequests().antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		.anyRequest().permitAll()
		.and().formLogin().loginPage("/dang-nhap")
		.successHandler(authenticationSuccessHandler)
//		.loginProcessingUrl("/login-controller")
		
//		.defaultSuccessUrl("/trang-chu")
		.failureUrl("/dang-nhap").and().exceptionHandling().accessDeniedPage("/403")
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
}
