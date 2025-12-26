package io.github.livenne.service;

import io.github.livenne.common.model.dto.goods.GoodsCommentSaveDTO;
import io.github.livenne.common.model.dto.goods.GoodsDTO;
import io.github.livenne.common.model.entity.Goods;
import io.github.livenne.common.model.entity.GoodsComment;

import java.util.List;

public interface GoodsService {
    List<Goods> getList();

    List<Goods> getList(List<Long> idList);

    Goods getById(Long id);

    void comment(GoodsCommentSaveDTO goodsCommentSaveDTO);

    List<GoodsComment> getComments(Long id);

    List<Goods> search(String kw);

    List<Goods> classify(String type);

    void save(GoodsDTO goodsDTO);

    void remove(Long id);

    void update(Long id, GoodsDTO goodsDTO);
}
