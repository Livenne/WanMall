package io.github.livenne.common.model.entity;

import io.github.livenne.IdType;
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
@Entity("user")
public class User {
    @Id(IdType.AUTO)
    private Long id;
    private Long addr;
    private Long level;
    private Long score;
    private String email;
    private String avatar;
    private String username;
    private String nickname;
    private String password;
}
