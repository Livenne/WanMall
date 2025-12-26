package io.github.livenne.controller;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.*;
import io.github.livenne.common.model.dto.goods.GoodsCommentDTO;
import io.github.livenne.common.model.dto.goods.GoodsCommentSaveDTO;
import io.github.livenne.common.model.dto.order.OrderCreateDTO;
import io.github.livenne.common.model.dto.order.OrderPayDTO;
import io.github.livenne.common.model.entity.Goods;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.service.GoodsService;
import io.github.livenne.service.ShopService;
import io.github.livenne.service.UserService;

import java.util.Map;
import java.util.StringJoiner;

@Controller("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @PostMapping("/cart/add/{id}")
    public ResponseEntity addCart(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        shopService.addCart(userId, id);
        return ResponseEntity.ok();
    }

    @PostMapping("/cart/sub/{id}")
    public ResponseEntity subCart(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        shopService.subCart(userId, id);
        return ResponseEntity.ok();

    }

    @PostMapping("/cart/remove/{id}")
    public ResponseEntity removeCart(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        shopService.removeCart(userId, id);
        return ResponseEntity.ok();
    }

    @PostMapping("/order/create")
    public ResponseEntity createOrder(@RequestBody OrderCreateDTO orderCreateDTO, @Attribute("userId") Long userId) {
        Long orderId = shopService.createOrder(userId, orderCreateDTO);
        return ResponseEntity.ok(Map.of("orderId", orderId));
    }

    @PostMapping("/order/pay")
    public ResponseEntity payOrder(@RequestBody OrderPayDTO orderPayDTO, @Attribute("userId") Long userId) {
        Boolean paySuccess = shopService.payOrder(userId, orderPayDTO.getOrderId(), orderPayDTO.getScore());

        if (paySuccess){
            return ResponseEntity.ok().message("支付成功");
        }
        return ResponseEntity.err().message("支付失败");
    }

    @PostMapping("/comment")
    public ResponseEntity comment(@RequestBody GoodsCommentDTO goodsCommentDTO, @Attribute("userId") Long userId) {

        Goods goods = goodsService.getById(goodsCommentDTO.getGoodsId());
        User user = userService.getById(userId);
        if (goods == null) {
            return ResponseEntity.err().message("商品不存在");
        }
        if (goodsCommentDTO.getComment().isBlank()){
            return ResponseEntity.err().message("评价不能为空");
        }
        StringJoiner pictures = new StringJoiner(",");
        goodsCommentDTO.getPictures().forEach(pictures::add);
        GoodsCommentSaveDTO commentSaveDTO = new GoodsCommentSaveDTO(
                goodsCommentDTO.getRating(),
                userId,
                goodsCommentDTO.getGoodsId(),
                System.currentTimeMillis(),
                goodsCommentDTO.getComment(),
                user.getUsername(),
                pictures.toString()
        );
        goodsService.comment(commentSaveDTO);
        return ResponseEntity.ok();
    }
}
