/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.configuration;

import mx.edu.utez.cli.cliweb4.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lenovo
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    
    
	@Autowired
	private UserService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/css/*","/imgs/*").permitAll()
	.anyRequest().authenticated()
	.and()
	.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
	.usernameParameter("username").passwordParameter("password")
	.defaultSuccessUrl("/loginsuccess").permitAll()
	.and()
	.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
	
	
	
	}
    
}
