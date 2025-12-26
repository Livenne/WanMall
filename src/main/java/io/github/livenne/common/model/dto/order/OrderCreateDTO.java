package io.github.livenne.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {
    private Long createTime;
    private String addr;
    private String payMethod;
    private Map<Long,Long> goodsMap;
}
