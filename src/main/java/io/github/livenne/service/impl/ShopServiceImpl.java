package io.github.livenne.service.impl;

import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.context.Service;
import io.github.livenne.common.model.dto.order.OrderCreateDTO;
import io.github.livenne.common.model.dto.order.OrderSaveDTO;
import io.github.livenne.common.model.dto.user.UserCartSaveDTO;
import io.github.livenne.common.model.entity.Order;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.common.model.entity.UserCart;
import io.github.livenne.repository.OrderRepository;
import io.github.livenne.repository.UserCartRepository;
import io.github.livenne.service.GoodsService;
import io.github.livenne.service.ShopService;
import io.github.livenne.service.UserService;

import java.util.Optional;
import java.util.StringJoiner;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private UserCartRepository userCartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @Override
    public UserCart getCart(Long userId, Long goodsId) {
        return userCartRepository.getCart(userId,goodsId);
    }

    @Override
    public void addCart(Long userId, Long goodsId) {
        UserCart cart = getCart(userId, goodsId);
        if (cart == null){
            userCartRepository.addCart(new UserCartSaveDTO(1L,userId,goodsId));
            return;
        }
        userCartRepository.updateCart(userId, goodsId, cart.getCount() + 1);
    }

    @Override
    public void subCart(Long userId, Long goodsId) {
        UserCart cart = getCart(userId, goodsId);
        if (cart == null){
            return;
        }

        if (cart.getCount() <= 1){
            userCartRepository.deleteCart(userId,goodsId);
            return;
        }

        userCartRepository.updateCart(userId, goodsId, cart.getCount() - 1);
    }

    @Override
    public void removeCart(Long userId, Long goodsId) {
        userCartRepository.deleteCart(userId,goodsId);
    }

    @Override
    public Long createOrder(Long userId, OrderCreateDTO orderCreateDTO) {

        double cost = orderCreateDTO.getGoodsMap().values().stream().mapToDouble(Double::valueOf).sum();
        StringJoiner goodsMap = new StringJoiner(",");
        orderCreateDTO.getGoodsMap().forEach((id,count)-> goodsMap.add(String.format("%s:%s", id, count)));
        OrderSaveDTO orderSaveDTO = new OrderSaveDTO(
                cost,
                userId,
                System.currentTimeMillis(),
                orderCreateDTO.getAddr(),
                goodsMap.toString(),
                orderCreateDTO.getPayMethod(),
                "未支付"
        );

        return orderRepository.createOrder(orderSaveDTO);
    }

    @Override
    public Boolean payOrder(Long userId, Long orderId, Long score) {
        User user = userService.getById(userId);
        long diff = Optional.ofNullable(user.getScore()).orElse(0L) - score;
        if (diff < 0){
            return false;
        }
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            return false;
        }
        if (!order.getUserId().equals(userId)) {
            return false;
        }

        //TODO 支付 => cost - score/100

        if (score > 0){
            userService.updateScore(userId,diff);
        }
        orderRepository.updateStatus(orderId,"已支付");

        return true;
    }
}
