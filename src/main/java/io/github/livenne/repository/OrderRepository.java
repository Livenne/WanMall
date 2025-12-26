package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.order.OrderSaveDTO;
import io.github.livenne.common.model.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends BaseMapper<Order> {

    @Insert
    Long createOrder(OrderSaveDTO orderSaveDTO);

    @Update
    void updateStatus(@Cond("id") Long id, @Column("status") String status);

    @Query
    Order getOrder(@Cond("id") Long id);

    @Query
    List<Order> getOrdersByUserId(@Cond("userId") Long userId);
}
