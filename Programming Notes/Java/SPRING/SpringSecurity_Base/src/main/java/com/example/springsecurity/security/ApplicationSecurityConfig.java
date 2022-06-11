package com.example.springsecurity.security;
//2:07:09 xsrf token kısmı tekrar bak

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import java.util.concurrent.TimeUnit;

import static com.example.springsecurity.security.ApplicationUserPermission.COURSE_WRITE;
import static com.example.springsecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {

        this.passwordEncoder = passwordEncoder;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name()) //2
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/courses", true)  // redirection
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe() // default to 2 weeks
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) //21 days
                    .key("somethingverysecured") // this is the key
                    // EXTENSION YOUR SESSION WIH REMEMBER ME
                    .rememberMeParameter("rememnber-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");


    }

    @Bean
    @Override // how you retreive your users from database
    protected UserDetailsService userDetailsService() {

       UserDetails annaSmithUser = User.builder()
               .username("annasmith")
               .password(passwordEncoder.encode("password"))
               //.roles(STUDENT.name())
               .authorities(STUDENT.getGrantedAuthorities())
               .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                //.roles(ADMIN.name()) // ROLE ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
                //.roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();


       return new InMemoryUserDetailsManager(
               annaSmithUser,
               lindaUser,
               tomUser
       );
    }
}
