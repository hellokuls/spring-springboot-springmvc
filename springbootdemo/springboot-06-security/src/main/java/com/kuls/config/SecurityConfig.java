package com.kuls.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/2 9:13 上午
 */
//AOP横切进去的
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页可以所以人访问，功能页只能有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限自动跳转登录页面
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("name")
                .passwordParameter("pwd")
                //登录成功跳转
                .successForwardUrl("/")//服务端跳转
                .defaultSuccessUrl("/"); //重定向，地址会发生变化


        //注销
        http.logout().logoutSuccessUrl("/");
        //关闭csrf,可能会导致登出失败
        http.csrf().disable();
        //开启记住我功能,cookie,默认二周 ,还可自定义
        http.rememberMe().rememberMeParameter("remeberme");


    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuls").password(new BCryptPasswordEncoder().encode("123123")).roles("vip2","vip3")
                .and()
                .withUser("kuls1").password(new BCryptPasswordEncoder().encode("123123") ).roles("vip1");
    }














}
