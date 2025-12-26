package io.github.livenne.common.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddrDTO {
    private Long phoneNumber;
    private String addr;
    private String name;
}
