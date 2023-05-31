//package com.tms.demorest.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
////@Configuration
//public class SecurityOldConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//            .antMatchers("/loginpage").permitAll()
//            .antMatchers("/mainpage").authenticated()
//            .and()
//            .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String user = "user";
//        String admin = "admin";
//        auth.inMemoryAuthentication()
////            .userDetailsPasswordManager(NoOpPasswordEncoder.getInstance())
//            .withUser(user).password(user).authorities("read")
//            .and()
//            .withUser(admin).password(admin).authorities("write");
//    }
//}
