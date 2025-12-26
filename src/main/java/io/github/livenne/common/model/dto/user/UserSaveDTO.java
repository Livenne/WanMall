package io.github.livenne.common.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {
    private Long level;
    private Long score;
    private String email;
    private String avatar;
    private String username;
    private String nickname;
    private String password;
}
