package com.example.filterinterceptoraopdifference.interceptor;

import com.example.filterinterceptoraopdifference.example.log.ExampleLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {

    private final ExampleLog exampleLog;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("CustomInterceptor preHandle 호출");
        log.info("인터셉터 CustomInterceptor 내의 exampleLog Bean 메서드 호출 시작 =====");
        exampleLog.testLog();
        log.info("인터셉터 CustomInterceptor 내의 exampleLog Bean 메서드 호출 끝 =====");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("CustomInterceptor postHandle 호출");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("CustomInterceptor afterCompletion 호출");
    }
}
