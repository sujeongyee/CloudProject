package com.server.cloud.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{


	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
 

	    @Bean
	    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	    	AuthenticationManager autheticationManager=authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));
	    	
	    	http.cors(Customizer.withDefaults())
	        	.csrf().disable()
	        	.formLogin().disable()
	        	.httpBasic().disable()
	            .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated() 
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);//기본세션 사용하지 않겠다는 뜻입니다 jwt사용해서 인증하겠다는 뜻
	    	
	    	
	    	
	    	http.addFilterBefore(new JwtRequestFilter(), BasicAuthenticationFilter.class);

	        return http.build();
	    }
	    @Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
			return authenticationConfiguration.getAuthenticationManager();
		}
	
}
