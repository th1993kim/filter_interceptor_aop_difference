package com.example.filterinterceptoraopdifference.example.controller;

import com.example.filterinterceptoraopdifference.example.vo.ExampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/example")
    public ResponseEntity<?> getExample(){
        ExampleVO exampleVO = new ExampleVO();
        exampleVO.setName("taehyun");
        exampleVO.setAge(11L);
        return ResponseEntity.status(HttpStatus.OK).body(exampleVO);
    }

}
