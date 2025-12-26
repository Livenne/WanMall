package io.github.livenne.common.model.vo;

import io.github.livenne.common.model.entity.UserAddr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddrVO {
    private Long id;
    private Long userId;
    private String addr;
    private String name;
    private Long phoneNumber;

    public UserAddrVO(UserAddr userAddr) {
        this.id = userAddr.getId();
        this.userId = userAddr.getUserId();
        String[] arr = userAddr.getAddr().split(",");
        this.addr = arr[0];
        this.name = arr[1];
        this.phoneNumber = Long.valueOf(arr[2]);
    }
}
