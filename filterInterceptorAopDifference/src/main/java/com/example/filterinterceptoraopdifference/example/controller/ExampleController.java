package com.example.filterinterceptoraopdifference.example.controller;

import com.example.filterinterceptoraopdifference.example.vo.ExampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExampleController {

    @GetMapping("/example")
    public ResponseEntity<?> getExample(){
        ExampleVO exampleVO = new ExampleVO();
        exampleVO.setName("kth");
        exampleVO.setAge(11L);
        log.info("============ Controller에서의 Example 호출 ===============");

        return ResponseEntity.status(HttpStatus.OK).body(exampleVO);
    }

}
