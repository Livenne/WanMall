package io.github.livenne.controller;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.*;
import io.github.livenne.common.model.dto.goods.GoodsDTO;
import io.github.livenne.common.model.dto.user.UserSaveDTO;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.service.GoodsService;
import io.github.livenne.service.UserService;

@Controller("/admin")
public class AdminController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public ResponseEntity getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @PostMapping("/user/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok();
    }

    @PostMapping("/user/add")
    public ResponseEntity addUser(@RequestBody UserSaveDTO userSaveDTO){
        userService.save(userSaveDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/user/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id,@RequestBody UserSaveDTO userSaveDTO) {
        userService.update(id,userSaveDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/goods/add")
    public ResponseEntity addGoods(@RequestBody GoodsDTO goodsDTO) {
        goodsService.save(goodsDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/goods/remove/{id}")
    public ResponseEntity removeGoods(@PathVariable("id") Long id) {
        goodsService.remove(id);
        return ResponseEntity.ok();
    }

    @PostMapping("/goods/update/{id}")
    public ResponseEntity updateGoods(@PathVariable("id") Long id,@RequestBody GoodsDTO goodsDTO) {
        goodsService.update(id,goodsDTO);
        return ResponseEntity.ok();
    }

}
