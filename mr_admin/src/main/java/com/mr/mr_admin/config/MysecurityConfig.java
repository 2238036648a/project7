package com.mr.mr_admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//启用Web安全的注解
@EnableGlobalMethodSecurity(prePostEnabled = true)//加上后使用的  @PreAuthorize("hasRole('ROLE_ADMIN')")才会生效
public class MysecurityConfig extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String admin123 = encoder.encode("aaa");
        System.out.println(admin123);
    }

    @Autowired
    private CommoUserService commoUserService;
    //设置拦截信息
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     /*   http.headers().frameOptions().disable();*/
        http.csrf().disable();
        http
                .formLogin()
                .defaultSuccessUrl("/page/index", false)//认证成功默认进入的页面
                .permitAll()
                .and()
                .authorizeRequests(authorize -> authorize
                        //放过拦截
                         .antMatchers("/login/**").permitAll()
                        /*.antMatchers("/static/**","/common/**").permitAll()
                        .antMatchers("/login/**").permitAll()
                        .antMatchers("/page/*").permitAll()*/
                        .antMatchers("/coupon/**").permitAll()
                        .antMatchers("/user/**").hasRole("USER")//必须认证通过
                        .anyRequest().authenticated()//除上面任何请求都必须经过身份验证
                );
    }


    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        //AbstractDaoAuthenticationConfigurer 提供了getUserDetailsService()和configure()，passwordEncoder()
        auth.userDetailsService(commoUserService).passwordEncoder(PasswordEncoder());
    }

    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}