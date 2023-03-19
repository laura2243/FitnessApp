package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * class for keeping the security configurations of the application
 * @Configuration annotation indicates that the class has @Bean definition methods
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint authEntryPoint;


    @Autowired
    public SecurityConfig( JwtAuthEntryPoint authEntryPoint) {
        this.authEntryPoint = authEntryPoint;
    }

    /**
     * Method which integrates a builder pattern that is going to build the actual security chain
     * It establishes the URLs' pattern that the filter will be applied on,
     * as well as authentication and authorization only to users who have roles
     *
     * @param http
     * @return SecurityFilterChain configured
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



    /**
     * Method that configures the authentication manager base on authentication configuration
     * @param authenticationConfiguration
     * @return AuthenticationManager
     * @throws Exception
     */
   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
   }

    /**
     * Method for encrypting the passwords using the BCrypt hashing function
     * @return BCryptPasswordEncoder
     */
   @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }


    /**
     * Method that allows us to access the authentication filter
     * @return JWTAuthenticationFilter
     */
   @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
   }


}
