package wanglin.Boss.service;

import org.springframework.stereotype.Service;
import wanglin.Boss.domain.Demo;
import wanglin.Boss.mapper.DemoMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {
    @Resource
    private DemoMapper DemoMapper;

    public List<Demo> list(){
        return DemoMapper.selectByExample(null);
    }

}
