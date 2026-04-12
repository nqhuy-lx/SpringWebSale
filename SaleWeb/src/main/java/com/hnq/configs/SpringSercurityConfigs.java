/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnq.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 *
 * @author huy14
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(
        basePackages = {
            "com.hnq.controllers",
            "com.hnq.repositories",
            "com.hnq.services"
        }
)
public class SpringSercurityConfigs {
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable()).authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/admin").hasRole("ADMIN")
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
        ).formLogin(form -> form.loginPage("/admin/login") // Đường dẫn tới trang đăng nhập
                .loginProcessingUrl("/login") // Đường dẫn xử lý POST
                .defaultSuccessUrl("/", true) // Chuyển hướng khi thành công
                .failureUrl("/admin/login?error=true") // Chuyển hướng khi thất bại
                .permitAll()
        ).logout((logout) -> logout.logoutSuccessUrl("/admin/login").permitAll());
        return http.build();
    }
    
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "uploadstatic",
                        "api_key", "192984554588374",
                        "api_secret", "pJB25mr86dVIemjALn2TgJXcj0M",
                        "secure", true));
        return cloudinary;
    }
}
