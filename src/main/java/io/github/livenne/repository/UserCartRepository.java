package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.user.UserCartSaveDTO;
import io.github.livenne.common.model.entity.UserCart;

import java.util.List;

@Repository
public interface UserCartRepository extends BaseMapper<UserCart> {
    @Query
    UserCart getCart(@Cond("userId") Long userId,@Cond("goodsId") Long goodsId);

    @Query
    List<UserCart> getCarts(@Cond("userId") Long userId);

    @Insert
    Long addCart(UserCartSaveDTO userCartSaveDTO);

    @Update
    void updateCart(@Cond("userId") Long userId, @Cond("goodsId") Long goodsId, @Column("count") Long count);

    @Delete
    void deleteCart(@Cond("userId") Long userId, @Cond("goodsId") Long goodsId);
}
