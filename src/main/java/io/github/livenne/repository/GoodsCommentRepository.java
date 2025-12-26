package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.Cond;
import io.github.livenne.annotation.orm.Insert;
import io.github.livenne.annotation.orm.Query;
import io.github.livenne.annotation.orm.Repository;
import io.github.livenne.common.model.dto.goods.GoodsCommentSaveDTO;
import io.github.livenne.common.model.entity.GoodsComment;

import java.util.List;

@Repository
public interface GoodsCommentRepository extends BaseMapper<GoodsComment> {

    @Insert
    void addComment(GoodsCommentSaveDTO commentSaveDTO);

    @Query
    List<GoodsComment> getByUserId(@Cond("userId") Long userId);

    @Query
    List<GoodsComment> getByGoodsId(@Cond("goodsId") Long goodsId);

}
