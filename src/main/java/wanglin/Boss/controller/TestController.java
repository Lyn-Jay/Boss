package wanglin.Boss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wanglin.Boss.domain.Test;
import wanglin.Boss.service.TestService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController{
    @Resource
    private TestService testService;

    @GetMapping("/hello")
    public String hello(){
        return "hell1o";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
       return  "hello," + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
