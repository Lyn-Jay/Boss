package wanglin.Boss.service;

import org.springframework.stereotype.Service;
import wanglin.Boss.domain.Ebook;
import wanglin.Boss.mapper.EbookMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper EbookMapper;

    public List<Ebook> list(){
        return EbookMapper.selectByExample(null);
    }

}
