package com.vti.testing.config;

import com.vti.testing.config.exception.AuthExceptionHandler;
import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthExceptionHandler authExceptionHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authExceptionHandler)
                .accessDeniedHandler(authExceptionHandler)
                .and()
                .authorizeRequests()
//                .antMatchers("/api/v1/departments/**").hasAuthority("ADMIN")
//                .antMatchers("/api/v1/accounts/**").hasAuthority("ADMIN")
                //
                //
                //
//                .antMatchers("/api/v1/departments").hasAnyAuthority("EMPLOYEE","MANAGER")
//                .antMatchers("/api/v1/accounts").hasAnyAuthority("EMPLOYEE","MANAGER")
//                .antMatchers("/api/v1/accounts/**").hasAuthority("ADMIN")
//                .antMatchers("/api/v1/accounts").hasAnyRole("ROLE_EMPLOYEE","ROLE_MANAGER")
//                .antMatchers("/api/v1/accounts/**").hasRole("ROLE_ADMIN")
//                .antMatchers("/api/v1/accounts/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
