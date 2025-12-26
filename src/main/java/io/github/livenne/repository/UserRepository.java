package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.user.UserSaveDTO;
import io.github.livenne.common.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends BaseMapper<User> {

    @Insert
    Long save(UserSaveDTO userSaveDTO);

    @Query
    User getById(@Cond("id") Long id);

    @Query
    User getByUsername(@Cond("username") String username);

    @Query
    User getByEmail(@Cond("email") String email);

    @Update
    void updateScore(@Cond("id") Long id, @Column("score") Long score);

    @Update
    void updateNickname(@Cond("id") Long id, @Column("nickname") String nickname);

    @Update
    void updatePassword(@Cond("id") Long id, @Column("password") String password);

    @Update
    void updateAvatar(@Cond("id") Long id, @Column("avatar") String url);

    @Update
    void updateDefAddr(@Cond("id") Long id, @Column("addr") Long addr);

    @Query
    List<User> getUserList();

    @Delete
    void delete(@Cond("id") Long id);

    @Update
    void update(@Cond("id") Long id, @Column UserSaveDTO userSaveDTO);
}
