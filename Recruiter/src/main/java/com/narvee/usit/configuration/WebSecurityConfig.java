package com.narvee.usit.configuration;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class WebSecurityConfig {

//	@Autowired
//private 	JwtRequestFilter requestFilter;
//
//	@Bean
//	public PasswordEncoder passordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		return httpSecurity.csrf().disable().authorizeHttpRequests().antMatchers("/register", "/authentication")
//				.permitAll().and().authorizeHttpRequests().antMatchers("/api/**").authenticated().and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class).build();
//
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManger(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
}
