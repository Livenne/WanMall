package io.github.livenne.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaveDTO {
    private Long cost;
    private Long userId;
    private Long createTime;
    private String addr;
    private String goodsMap;
    private String payMethod;
    private Boolean status;
}
