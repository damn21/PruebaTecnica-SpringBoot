package com.andres.testspring.auth;

import com.andres.testspring.auth.jwtUtils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtFilter filter;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws
            Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/v1/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.anonymous().disable()
//                .antMatcher("/api/v1/login")
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
//                .and()
//                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/api/v1/login")).disable()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

//    private AccessDeniedHandler accessDeniedHandler() {
//        return null;
//    }

    //private static final String HEADER_NAME = "Authorization";

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
      //  ApiKeyAuthFilter filter = new ApiKeyAuthFilter(HEADER_NAME);
        //filter.setAuthenticationManager(new ApiKeyAuthManager());

        //http.antMatcher("/api/v1/**")
          //      .csrf()
            //    .disable()
              //  .sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                //.addFilter(filter)
                //.authorizeRequests() //default
                //.anyRequest()        //default
                //.authenticated();    //default

        // http.httpBasic(withDefaults()); //for basic authentication
    //}
}
