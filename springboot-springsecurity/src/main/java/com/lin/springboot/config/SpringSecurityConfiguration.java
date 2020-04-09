package com.lin.springboot.config;


import com.lin.springboot.security.SecurityUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//启动SpringSecurity 注解支持
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {


    /*@Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;*/



    //1.配置拦截规则，校验
    //注意事项：登录页面的路径，和登录请求的，必须保持一致
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //校验所有授权的请求。
        http.authorizeRequests()
                //指定放开的路径，antMatchers指定匹配的路径，
                .antMatchers("/", "/home")
                //permitAll(),对前面指定的路径放开所有权限
                .permitAll()
                //其他任何请求的，
                .anyRequest()
                //authenticated()校验权限
                .authenticated()

                .and()

                //指定登录表单设置，
                .formLogin()
                //loginPage设置登录页面
                .loginPage("/login")
                //permitAll()登录页面不需要授权，直接可以访问
                .permitAll()

                .and()

                //设置注销。如果注销路径不设置/logout。设置注销也不需要授权。注销成功后，清楚用户状态cookie
                .logout().permitAll().deleteCookies("JSESSIONID");


    }

    //2.配置获得认证信息，写死。授权
    @Bean //授权对象需要注入Spring容器里面
    @Override
    protected UserDetailsService userDetailsService() {

        /*//构建一个密码加密对象
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //构建一个用户服务对象
        UserDetails userDetails = User.withUsername("lin").password(encoder.encode("123456")).roles("ADMIN").build();
        //UserDetailService的内置实现类

        return new InMemoryUserDetailsManager(userDetails);*/


        /*//系统自带的
        JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager();
        detailsManager.setDataSource(dataSource);
        return detailsManager;*/


        //自定义
        return new SecurityUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
