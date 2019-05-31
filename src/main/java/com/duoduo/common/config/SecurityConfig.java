
package com.duoduo.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * spring security安全配置
 * @author lixiaolong
 * @create 2019-05-08 17:47
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 加密工具类
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         //super.configure(http);
            http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")//配置登录页面
                .successForwardUrl("/index.html")
                .failureForwardUrl("/login.html")
                .and()
                .authorizeRequests().antMatchers(
                "/login.html",
                            "/**/*.js",
                            "/**/*.css",
                            "/**/*.jpg",
                            "/**/*.png",
                            "/**/*.gif",
                            "/**/*.woff",
                            "/**/*.woff2",
                            "/**/*.ico") //排除静态文件
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

}

