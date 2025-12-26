package io.github.livenne.common.model.entity;

import io.github.livenne.annotation.orm.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity("goods_comment")
public class GoodsComment {
    private Long id;
    private Long rating;
    private Long userId;
    private Long goodsId;
    private Long createTime;
    private String comment;
    private String username;
    private String pictures;
}
