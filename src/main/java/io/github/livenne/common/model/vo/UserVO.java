package io.github.livenne.common.model.vo;

import io.github.livenne.common.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Long id;
    private Long addr;
    private Long level;
    private Long score;
    private Long cartCount;
    private String email;
    private String avatar;
    private String username;
    private String nickname;

    public UserVO(User user,Long cartCount) {
        this.id = user.getId();
        this.addr = user.getAddr();
        this.level = user.getLevel();
        this.score = user.getScore();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
        this.cartCount = cartCount;
        this.username = user.getUsername();
        this.nickname = user.getNickname();
    }
}
