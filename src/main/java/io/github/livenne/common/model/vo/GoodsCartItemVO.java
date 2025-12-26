package io.github.livenne.common.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCartItemVO {
    private Long id;
    private Double price;
    private Long count;
    private Long discount;
    private String name;
    private String cover;
    private String description;
    private Map<String,String> args;

    public GoodsCartItemVO(GoodsVO goods, Long count) {
        this.id = goods.getId();
        this.price = goods.getPrice();
        this.count = count;
        this.discount = goods.getDiscount();
        this.name = goods.getName();
        this.cover = goods.getCover();
        this.description = goods.getDescription();
        this.args = goods.getArgs();
    }
}
