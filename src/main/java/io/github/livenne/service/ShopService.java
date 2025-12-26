package io.github.livenne.service;

import io.github.livenne.common.model.dto.order.OrderCreateDTO;
import io.github.livenne.common.model.entity.UserCart;

public interface ShopService {

    UserCart getCart(Long userId, Long goodsId);

    void addCart(Long userId,Long goodsId);

    void subCart(Long userId, Long goodsId);

    void removeCart(Long userId, Long goodsId);

    Long createOrder(Long userId,OrderCreateDTO orderCreateDTO);

    Boolean payOrder(Long userId, Long orderId, Long score);
}
