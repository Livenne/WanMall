package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.MatchType;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.goods.GoodsDTO;
import io.github.livenne.common.model.entity.Goods;

import java.util.List;

@Repository
public interface GoodsRepository extends BaseMapper<Goods> {
    @Query
    List<Goods> getGoods();

    @Query
    Goods getById(@Cond("id") Long id);

    @Query
    List<Goods> search(@Cond(value = "name", type = MatchType.LIKE) String kw);

    @Query
    List<Goods> classify(@Cond(value = "type", type = MatchType.LIKE) String type);

    @Insert
    Long save(GoodsDTO goodsDTO);

    @Delete
    void delete(@Cond("id") Long id);

    @Update
    void update(@Cond("id") Long id, @Column GoodsDTO goodsDTO);
}
