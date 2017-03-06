package com.cone.utils.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.cone.auth.service.impl.CustomUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
	@Bean
    UserDetailsService customUserService() {
        return new CustomUserServiceImpl();
    }
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
			.authorizeRequests()
			.antMatchers("/", "/demo/index").permitAll()
			.antMatchers("/demo/role/test/dd").hasRole("USER222")
			.antMatchers("/demo/role/test/**").hasRole("USER")
			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/demo/main",true)
			.and()
			.logout()
			//.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.permitAll()
			.invalidateHttpSession(true);
	}

}
