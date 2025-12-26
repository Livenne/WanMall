package io.github.livenne.common.model.dto.goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCommentDTO {
    private Long rating;
    private Long goodsId;
    private String comment;
    private List<String> pictures;
}
