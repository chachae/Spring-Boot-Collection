package com.chachae.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chachae
 * @since 2020/4/21 17:04
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/r/p1").hasAnyAuthority("p1")
        .antMatchers("/r/p2").hasAnyAuthority("p2")
        .antMatchers("/r/**")
        .authenticated()
        .anyRequest()
        .permitAll()
        .and()
        .formLogin()
        .loginPage("/login-view")
        .loginProcessingUrl("/login")
        .successForwardUrl("/success")
        .and()
        // session 会话管理
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
  }
}
