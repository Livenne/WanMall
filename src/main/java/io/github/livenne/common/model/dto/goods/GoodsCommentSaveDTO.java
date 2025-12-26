package io.github.livenne.common.model.dto.goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCommentSaveDTO {
    private Long rating;
    private Long userId;
    private Long goodsId;
    private Long createTime;
    private String comment;
    private String username;
    private String pictures;
}
