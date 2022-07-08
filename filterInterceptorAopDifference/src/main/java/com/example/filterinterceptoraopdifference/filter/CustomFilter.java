package com.example.filterinterceptoraopdifference.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Iterator;

@Slf4j
@Component
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("Servlet Filter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter 시작 ================Start ===============");

        Enumeration<String> attributeNames = request.getAttributeNames();
        ServletInputStream inputStream = request.getInputStream();
        StringBuilder sb  = new StringBuilder();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while((line = br.readLine()) !=null){
            if(line.indexOf(" ")>0){
                sb.append("\n");
            }
            sb.append(line);
        }
        Iterator<String> names = attributeNames.asIterator();
        while(names.hasNext()){
            String next = names.next();

            log.info("next param = {}",next);
        }
        log.info("body ={}",sb.toString());
        log.info("content type = {}",request.getContentType());
        log.info("filter 종료 ===============END ================");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("Servlet Filter Destroy");
    }
}
