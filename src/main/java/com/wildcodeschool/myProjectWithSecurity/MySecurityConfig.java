package com.wildcodeschool.myProjectWithSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/avengers/assemble").hasRole("Hero")
                .antMatchers("/secret-bases").hasRole("Director")
                .antMatchers("/").permitAll()
                .and()
            .formLogin() //login-Seite soll aufgerufen werden
                .and()
            .httpBasic();//Authentifizierung
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser("Tony Stark")
                .password(encoder.encode("password"))
                .roles("Hero")
                .and()
            .withUser("Steve Guy")
                .password(encoder.encode("password"))
                .roles("USER") 
                .and()
            .withUser("Nick Fury")
                .password(encoder.encode("password"))
                .roles("Director");
        

        // Steve Guy (alles also welcome to the shield) Tony Stark ( Hero), Nick Fury (director).
    }



    
}
