package io.github.livenne.common.model.dto.goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {
    private Double price;
    private Long discount;
    private Long inventory;
    private String name;
    private String type;
    private String args;
    private String addr;
    private String cover;
    private String pictures;
    private String description;
}
