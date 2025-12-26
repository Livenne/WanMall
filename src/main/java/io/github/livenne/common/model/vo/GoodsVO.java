package io.github.livenne.common.model.vo;

import io.github.livenne.common.model.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVO {
    private Long id;
    private Long sales;
    private Double price;
    private Long discount;
    private Long inventory;
    private String name;
    private String type;
    private Map<String,String> args;
    private String addr;
    private String cover;
    private List<String> pictures;
    private String description;

    public GoodsVO(Goods goods) {
        this.id = goods.getId();
        this.sales = goods.getSales();
        this.price = goods.getPrice();
        this.discount = goods.getDiscount();
        this.inventory = goods.getInventory();
        this.name = goods.getName();
        this.type = goods.getType();
        Map<String, String> args = new HashMap<>();
        Arrays.stream(goods.getArgs().split(",")).map(str->str.split(":")).forEach(arg->args.put(arg[0],arg[1]));
        this.args = args;
        this.addr = goods.getAddr();
        this.cover = goods.getCover();
        this.pictures = Arrays.stream(goods.getPictures().split(",")).toList();
        this.description = goods.getDescription();
    }
}
