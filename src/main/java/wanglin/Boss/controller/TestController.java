package wanglin.Boss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @GetMapping("/hello")
    public String hello(){
        return "hell1o";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
       return  "hello," + name;
    }
}
