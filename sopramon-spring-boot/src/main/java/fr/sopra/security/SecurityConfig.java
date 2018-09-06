package fr.sopra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	AuthFailureHandler authFailureHandler = new AuthFailureHandler();
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/assets/**").permitAll()
	.antMatchers("/home").permitAll()
	.antMatchers("/inscription").permitAll()
	.antMatchers("/**").hasAnyRole("ADMIN", "USER")
	.and()
	.formLogin()
	.loginPage("/home")
	.loginProcessingUrl("/perform_login")
	.failureHandler(authFailureHandler)
	.defaultSuccessUrl("/menuSopramon", true)
	.failureUrl("/home?error=true")
	.permitAll()
	.and()
	.logout()
	.logoutUrl("/ma_page_de_deconnexion")
	.logoutSuccessUrl("/ma_page_de_login")
	.permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	

	
}