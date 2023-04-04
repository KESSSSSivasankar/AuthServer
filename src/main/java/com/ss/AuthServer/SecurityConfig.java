package com.ss.AuthServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager; 

@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 
	@Bean 
	   public UserDetailsService userDetailsService() {
	      UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(); 
	      UserDetails user = User.withUsername("john") 
	         .password("12345") .authorities("read") 
	      .build(); userDetailsManager.createUser(user); return userDetailsManager; 
	   } 
	    
	   @Override 
	   @Bean 
	   public AuthenticationManager authenticationManagerBean() throws Exception { 
	      return super.authenticationManagerBean(); 
	   }
}