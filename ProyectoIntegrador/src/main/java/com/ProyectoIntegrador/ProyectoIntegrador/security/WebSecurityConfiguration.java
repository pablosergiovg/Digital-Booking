package com.ProyectoIntegrador.ProyectoIntegrador.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((authz) -> {
                            try {
                                authz
                                    .requestMatchers("/authenticate").permitAll()
//                                    .requestMatchers(HttpMethod.GET,"/api/productos/random").hasAnyRole("USER", "ADMIN")
                                    .requestMatchers(HttpMethod.POST,"/api/reservas").authenticated()
//                                    .requestMatchers(HttpMethod.GET, "api/productos/random" ).authenticated()
                                    .anyRequest().permitAll()
                                    .and().sessionManagement()
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                //TODO
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt//
//                        .jwtAuthenticationConverter()
//                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}
