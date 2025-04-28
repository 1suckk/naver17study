package bit.day0417.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,
			CustomLoginSuccessHandler loginSuccessHandler) throws Exception
	{
		http
		.authorizeHttpRequests(auth->auth
				.requestMatchers("/","/login","/joinproc").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/mypage/**").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()
		);
		
		http
		.formLogin((auth)->auth.loginPage("/login")
				.loginProcessingUrl("/loginproc")
				.successHandler(loginSuccessHandler)
				.permitAll())
		.logout(logout->logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/"));
		
		http
		.exceptionHandling(exception->exception
				.accessDeniedPage("/access-denied"));
		
		http
		.csrf(auth->auth.disable());
		
		return http.build();
	}
}
