package wanglin.Boss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wanglin.Boss.domain.Demo;
import wanglin.Boss.service.DemoService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DemoController {
    @Resource
    private DemoService demoService;

    @GetMapping("/demo/list")
    public List<Demo> list(){
        return demoService.list();
    }
}
