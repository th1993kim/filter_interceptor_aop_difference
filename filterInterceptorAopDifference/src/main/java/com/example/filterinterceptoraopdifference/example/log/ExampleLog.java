package com.example.filterinterceptoraopdifference.example.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleLog {
    public void testLog(){
        log.info("Spring Container내의 ExampleLog Bean의 Test Log 호출");
    }
}
