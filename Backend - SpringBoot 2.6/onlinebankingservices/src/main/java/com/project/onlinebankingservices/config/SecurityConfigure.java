package com.project.onlinebankingservices.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource mydataSource;

//	@Autowired
//	private UserDetailsService myuserDetailsService;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http	
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/login")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.defaultSuccessUrl("/", true)

				.and()
				.logout()
				.logoutSuccessUrl("/loggedout")
				.permitAll()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/perform_logout" ,"GET" ) )
				.invalidateHttpSession(true);
//			.deleteCookies ( "JSESSIONID" )
//			.permitAll();
//			.logoutUrl("/login");

//			.addLogoutHandler(logoutHandler)                                         
//			.deleteCookies(cookieNamesToClear)                                       
//			.and()
//			 * .logoutSuccessHandler(logoutSuccessHandler)  
	}

//	@Override
//	protected void configure(final HttpSecurity http) throws Exception
//	{
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/register/").permitAll()
//			.anyRequest()
//			.permitAll();
//			
////			.logoutUrl("/login");
//		
//			
//			/*.addLogoutHandler(logoutHandler)                                         
//			.deleteCookies(cookieNamesToClear)                                       
//			.and()
//			 * .logoutSuccessHandler(logoutSuccessHandler)  */
//	}
//	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.userDetailsService(myuserDetailsService);

//		auth.inMemoryAuthentication()
//		.withUser( "admin" ).password(passwordEncoder().encode("admin")).roles("USER");
//		

		auth.jdbcAuthentication().dataSource(mydataSource);

	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}