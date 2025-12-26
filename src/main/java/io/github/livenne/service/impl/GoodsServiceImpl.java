package io.github.livenne.service.impl;

import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.context.Service;
import io.github.livenne.common.model.dto.goods.GoodsCommentSaveDTO;
import io.github.livenne.common.model.dto.goods.GoodsDTO;
import io.github.livenne.common.model.entity.Goods;
import io.github.livenne.common.model.entity.GoodsComment;
import io.github.livenne.repository.GoodsCommentRepository;
import io.github.livenne.repository.GoodsRepository;
import io.github.livenne.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsCommentRepository goodsCommentRepository;

    @Override
    public List<Goods> getList() {
        return goodsRepository.getGoods();
    }

    @Override
    public List<Goods> getList(List<Long> idList) {
        return idList.stream().map(this::getById).toList();
    }

    @Override
    public Goods getById(Long id) {
        return goodsRepository.getById(id);
    }

    @Override
    public void comment(GoodsCommentSaveDTO goodsCommentSaveDTO) {
        goodsCommentRepository.addComment(goodsCommentSaveDTO);
    }

    @Override
    public List<GoodsComment> getComments(Long id) {
        return goodsCommentRepository.getByGoodsId(id);
    }

    @Override
    public List<Goods> search(String kw) {
        return goodsRepository.search(kw);
    }

    @Override
    public List<Goods> classify(String type) {
        return goodsRepository.classify(type);
    }

    @Override
    public void save(GoodsDTO goodsDTO) {
        goodsRepository.save(goodsDTO);
    }

    @Override
    public void remove(Long id) {
        goodsRepository.delete(id);
    }

    @Override
    public void update(Long id, GoodsDTO goodsDTO) {
        goodsRepository.update(id,goodsDTO);
    }
}
