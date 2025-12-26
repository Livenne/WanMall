package io.github.livenne.common.model.entity;

import io.github.livenne.annotation.orm.Entity;
import io.github.livenne.annotation.orm.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity("orders")
public class Order {
    @Id
    private Long id;
    private Double cost;
    private Long userId;
    private Long createTime;
    private String addr;
    private String goodsMap;
    private String payMethod;
    private String status;
}
