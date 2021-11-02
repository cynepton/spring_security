package com.cynepton.spring_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.cynepton.spring_security.security.ApplicationUserRole.*;

/**
 * ApplicationSecurityConfig
 * <br>
 * <code>com.cynepton.spring_security.security.ApplicationSecurityConfig</code>
 * <br>
 *
 * @author Isaac Aderonmu
 * @since 24 October 2021
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails wonderWoman = User.builder()
                .username("diana")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())
                .build();

        UserDetails batman = User.builder()
                .username("batman")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();

        UserDetails robin = User.builder()
                .username("robin")
                .password(passwordEncoder.encode("password"))
                .roles(ADMINTRAINEEE.name())
                .build();

        return new InMemoryUserDetailsManager(
                wonderWoman, batman, robin
        );
    }
}
