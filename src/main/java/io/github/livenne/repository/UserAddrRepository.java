package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.user.UserAddrSaveDTO;
import io.github.livenne.common.model.entity.UserAddr;

import java.util.List;

@Repository
public interface UserAddrRepository extends BaseMapper<UserAddr> {

    @Query
    UserAddr getAddr(@Cond("id") Long id);

    @Query
    List<UserAddr> getUserAddr(@Cond("userId") Long userId);

    @Insert
    Long addAddr(UserAddrSaveDTO userAddrSaveDTO);

    @Update
    void updateAddr(@Cond("id") Long id, @Cond("userId") Long userId, @Column("addr") String addr);

    @Delete
    void deleteAddr(@Cond("id") Long id, @Cond("userId") Long userId);

}
