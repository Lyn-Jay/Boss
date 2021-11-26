package wanglin.Boss.controller;

import org.springframework.web.bind.annotation.*;
import wanglin.Boss.req.EbookQueryReq;
import wanglin.Boss.req.EbookSaveReq;
import wanglin.Boss.resp.CommonResp;
import wanglin.Boss.resp.EbookQueryResp;
import wanglin.Boss.resp.PageResp;
import wanglin.Boss.service.EbookService;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable long id){
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }



}
