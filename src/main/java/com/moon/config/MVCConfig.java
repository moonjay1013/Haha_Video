package com.moon.config;

import com.moon.component.LocalResolver;
import com.moon.component.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author moonjay
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    private final Logger log = LoggerFactory.getLogger(MVCConfig.class);

    // 将自定义的区域信息解析器以组件的形式添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new LocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/css/**", "/images/**", "/js/**", "/fonts/**");
    }
}