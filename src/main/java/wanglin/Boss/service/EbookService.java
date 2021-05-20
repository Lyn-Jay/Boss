package wanglin.Boss.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import wanglin.Boss.domain.Ebook;
import wanglin.Boss.domain.EbookExample;
import wanglin.Boss.mapper.EbookMapper;
import wanglin.Boss.req.EbookReq;
import wanglin.Boss.resp.EbookResp;
import wanglin.Boss.util.CopyUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%" + req.getName() + "%");
        }



        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);


        //列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        return list;

    }

}
