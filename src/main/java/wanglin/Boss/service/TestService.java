package wanglin.Boss.service;

import org.springframework.stereotype.Service;
import wanglin.Boss.domain.Test;
import wanglin.Boss.mapper.TestMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();

    }

}
