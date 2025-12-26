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
public class Orders {
    @Id
    private Long id;
    private Long cost;
    private Long count;
    private Long userId;
    private Long createTime;
    private String addr;
    private String payMethod;
    private String goodsArray;
    private Boolean status;
}
