package wanglin.Boss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/hello/post")
    public <name> String helloPost(String name){
       return  "hello," + name;
    }
}
