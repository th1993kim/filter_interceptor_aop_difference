package com.example.filterinterceptoraopdifference.config;

import com.example.filterinterceptoraopdifference.filter.CustomTestFilter;
import com.example.filterinterceptoraopdifference.interceptor.CustomInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomTestFilter customFilter;
    private final CustomInterceptor customInterceptor;

    //필터를 Bean으로 등록해주기
    @Bean
    public FilterRegistrationBean customFilter(){
        FilterRegistrationBean<Filter>  filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(customFilter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    //InterCeptor 등록해주기
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor);
    }
}
