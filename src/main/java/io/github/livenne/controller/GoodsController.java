package io.github.livenne.controller;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.Controller;
import io.github.livenne.annotation.servlet.GetMapping;
import io.github.livenne.annotation.servlet.PathVariable;
import io.github.livenne.annotation.servlet.RequestParm;
import io.github.livenne.common.model.vo.GoodsVO;
import io.github.livenne.service.GoodsService;

@Controller("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/recommend")
    public ResponseEntity getRecommend(){
        return ResponseEntity.ok(goodsService.getList().stream().map(GoodsVO::new).toList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getGoods(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new GoodsVO(goodsService.getById(id)));
    }

    @GetMapping("/get/{id}/comments")
    public ResponseEntity getComments(@PathVariable("id") Long id) {
        return ResponseEntity.ok(goodsService.getComments(id));
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParm("kw") String kw){
        return ResponseEntity.ok(goodsService.search(kw).stream().map(GoodsVO::new).toList());
    }

    @GetMapping("/classify")
    public ResponseEntity classify(@RequestParm("type") String type) {
        return ResponseEntity.ok(goodsService.classify(type).stream().map(GoodsVO::new).toList());
    }


}
