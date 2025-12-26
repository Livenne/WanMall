package io.github.livenne.common.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFavoriteSaveDTO {
    private Long userId;
    private Long goodsId;
}
