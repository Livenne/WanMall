package io.github.livenne.common.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaveDTO {
    private Double cost;
    private Long userId;
    private Long createTime;
    private String addr;
    private String goodsMap;
    private String payMethod;
    private String status;
}
