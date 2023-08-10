package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		//to make signin url public
		.antMatchers("/signin").permitAll()
		.antMatchers("/app/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		   .anyRequest()
		   .authenticated()
		   .and()
		   //.httpBasic();
		   .formLogin()
		   //step2 if you want to see in url
		   .loginPage("/signin")
		   .loginProcessingUrl("/doLogin")
		   .defaultSuccessUrl("/users/**");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Preeti")
		.password(this.passwordEncoder().encode("welcome"))
		.roles("NORMAL");
		
		auth.inMemoryAuthentication()
		.withUser("Manish")
		.password(this.passwordEncoder().encode("Amazon"))
		.roles("ADMIN");
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
}
