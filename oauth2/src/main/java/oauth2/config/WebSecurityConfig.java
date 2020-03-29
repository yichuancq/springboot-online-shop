package oauth2.config;

import oauth2.handler.CustomAccessDeniedHandler;
import oauth2.handler.CustomAuthenticationFailureHandler;
import oauth2.handler.CustomPermissionEvaluator;
import oauth2.handler.CustomerSavedRequestAwareAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomerSavedRequestAwareAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * @return
     */
    @Autowired
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new CustomPermissionEvaluator());
        return handler;
    }

    /**
     * 静态资源设置
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        //不拦截静态资源,所有用户均可访问的资源
        webSecurity.ignoring().antMatchers(
                "/",
                "/css/**",
                "/js/**",
                "/images/**",
                "/layui/**"
        );
    }

    /**
     * 认证
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //webSecurityExpressionHandler();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密算法
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    /**
     * http请求设置
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //注释就是使用 csrf 功能
        http.headers().frameOptions().disable();//解决 in a frame because it set 'X-Frame-Options' to 'DENY' 问题
        //http.anonymous().disable();
        http.logout().logoutUrl("/welcome");
        http.authorizeRequests()
                .antMatchers("/login/**", "/login")//不拦截登录相关方法
                .permitAll()
                .antMatchers("/welcome/**", "/welcome")//不拦截登录相关方法
                .permitAll()
                .antMatchers("/index/**", "/index")//不拦截登录相关方法
                .permitAll()
                .antMatchers("/403/**", "/403")//不拦截登录相关方法
                .permitAll()
                .antMatchers("/logout/**", "/logout")//不拦截登录相关方法
                .permitAll()
                .antMatchers("/favicon.ico/**", "/favicon.ico")//不拦截相关方法
                .permitAll()
                .antMatchers("/loginOutSuccess/**", "/loginOutSuccess")//不拦截登录相关方法
                .permitAll()
                //.antMatchers("/user").hasRole("ADMIN")  // user接口只有ADMIN角色的可以访问
                .anyRequest()
                .authenticated()// 任何尚未匹配的URL只需要验证用户即可访问
                // swagger start
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                //swagger end
                .anyRequest()
                .authenticated()// 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest()
                //其他所有资源都需要登陆后才能访问
                .access("@rbacPermission.hasPermission(request, authentication)")//根据账号权限访问
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username") //登录用户名参数
                .passwordParameter("password") //登录密码参数
                .successForwardUrl("/index").permitAll()
                .defaultSuccessUrl("/welcome").permitAll()
                .failureUrl("/error").permitAll()
//               /设置默认登录成功跳转页面
                .successHandler(successHandler)//登录成功处理器
                .failureHandler(customAuthenticationFailureHandler)//登录失败处理器
                .and()
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler) //无权限处理器
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/loginOutSuccess").permitAll()
                .and()
                .rememberMe()
//               //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7);
    }
}
