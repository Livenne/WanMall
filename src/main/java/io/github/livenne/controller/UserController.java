package io.github.livenne.controller;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.*;
import io.github.livenne.common.model.dto.user.UserAddrDTO;
import io.github.livenne.common.model.dto.user.UserUpdateDTO;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.common.model.entity.UserCart;
import io.github.livenne.common.model.vo.GoodsCartItemVO;
import io.github.livenne.common.model.vo.GoodsVO;
import io.github.livenne.common.model.vo.UserAddrVO;
import io.github.livenne.common.model.vo.UserVO;
import io.github.livenne.service.AuthService;
import io.github.livenne.service.GoodsService;
import io.github.livenne.service.UserService;

import java.util.List;
import java.util.Map;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/addr/setdef/{id}")
    public ResponseEntity setDefAddr(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        userService.updateDefAddr(userId,id);
        return ResponseEntity.ok();
    }

    @PostMapping("/addr/add")
    public ResponseEntity addAddr(@RequestBody UserAddrDTO userAddrDTO, @Attribute("userId") Long userId){
        userService.addAddr(userId, userAddrDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/addr/remove/{id}")
    public ResponseEntity removeAddr(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        userService.removeAddr(userId, id);
        return ResponseEntity.ok();
    }

    @PostMapping("/addr/update/{id}")
    public ResponseEntity updateAddr(@PathVariable("id") Long id,
                                     @RequestBody UserAddrDTO userAddrDTO,
                                     @Attribute("userId") Long userId) {
        userService.updateAddr(userId, id, userAddrDTO);
        return ResponseEntity.ok();

    }

    @GetMapping("/addr")
    public ResponseEntity getAddr(@Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.getAddrList(userId).stream().map(UserAddrVO::new).toList());
    }

    @PostMapping("/nickname/update")
    public ResponseEntity updateNickname(@RequestBody Map<String, String> map, @Attribute("userId") Long userId) {

        String nickname = map.getOrDefault("nickname","");
        if (!AuthService.NICKNAME.matcher(nickname).matches()) {
            return ResponseEntity.err().message("昵称格式不正确，仅允许中文、数字、英文、下划线且长度在3-12以内");
        }

        userService.updateNickname(userId,nickname);
        return ResponseEntity.ok();
    }

    @PostMapping("/avatar/update")
    public ResponseEntity updateAvatar(@RequestBody Map<String, String> map, @Attribute("userId") Long userId) {
        userService.updateAvatar(userId,map.getOrDefault("url",""));
        return ResponseEntity.ok();
    }

    @PostMapping("/password/update")
    public ResponseEntity updatePassword(@RequestBody Map<String, String> map, @Attribute("userId") Long userId) {
        User user = userService.getById(userId);
        String oldPassword = map.getOrDefault("oldPassword","");
        String newPassword = map.getOrDefault("newPassword","");
        if (!user.getPassword().equals(oldPassword)){
            return ResponseEntity.err().message("原密码输入与当前密码不符");
        }
        if (!AuthService.PASSWORD.matcher(newPassword).matches()) {
            return ResponseEntity.err().message("密码格式不正确，仅允许数字、英文、下划线且长度在8-18以内");
        }
        userService.updatePassword(userId,newPassword);
        return ResponseEntity.ok();

    }

    @GetMapping("/profile")
    public ResponseEntity getProfile(@Attribute("userId") Long userId) {
        long carts = userService.getCarts(userId).size();
        return ResponseEntity.ok(new UserVO(userService.getById(userId), carts));
    }


    @GetMapping("/cart")
    public ResponseEntity getCart(@Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.getCarts(userId).stream()
                .map(cart -> new GoodsCartItemVO(
                        new GoodsVO(goodsService.getById(cart.getGoodsId())),
                        cart.getCount()
                ))
                .toList());
    }

    @GetMapping("/favorites")
    public ResponseEntity getFavorite(@Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.getFavorites(userId).stream().map(GoodsVO::new).toList());
    }

    @GetMapping("/favorite/{id}")
    public ResponseEntity isFavorite(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.isFavorite(userId, id));
    }

    @PostMapping("/favorite/{id}")
    public ResponseEntity favorite(@PathVariable("id") Long id, @Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.favorite(userId,id));
    }

    @GetMapping("/comments")
    public ResponseEntity getComments(@Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.getComments(userId));
    }

    @GetMapping("/orders")
    public ResponseEntity getOrders(@Attribute("userId") Long userId) {
        return ResponseEntity.ok(userService.getOrders(userId));
    }
}
