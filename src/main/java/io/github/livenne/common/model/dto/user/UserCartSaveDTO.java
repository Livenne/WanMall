package io.github.livenne.common.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCartSaveDTO {
    private Long count;
    private Long userId;
    private Long goodsId;
}
