/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.config;

import java.util.Arrays;
import mx.gob.issemym.idc.filter.AuthFilter;
import mx.gob.issemym.idc.filter.CORSFilter;
import mx.gob.issemym.idc.filter.IdcFilter;
import mx.gob.issemym.idc.filter.WebFilter;
//import mx.gob.issemym.idc.handler.CustomSuccessHandler;
import mx.gob.issemym.idc.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author Bryan Valdez Jara <Bryan at ibryan.valdez@gmail.com>
 */
@Configuration
@EnableWebSecurity
public class IdcSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("CustomUserDetailsServiceImpl")
    private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsServiceImpl);
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http.cors().and().csrf().disable().authorizeRequests()
                //          .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new AuthFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new WebFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
//                .httpBasic();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/create");
    }    

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
////        CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowedOrigins(Arrays.asList("*"));
////        configuration.setAllowCredentials(true);
////        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
////        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", configuration);
////        return source;
//    }

//    
//    @Autowired
//    CustomSuccessHandler customSuccessHandler;
//    
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);    
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }     
//    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .successHandler(customSuccessHandler)
//                    .permitAll().usernameParameter("username").passwordParameter("password")
//                .and()
//                    .sessionManagement()
//                    .invalidSessionUrl("/login")
//                .and()
//                    .logout().permitAll()
//                .and()
//                    .addFilterAfter(new IdcFilter(), BasicAuthenticationFilter.class);
//        
//        
//        
////               .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
//    }    
}
