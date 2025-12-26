package io.github.livenne.repository;

import io.github.livenne.BaseMapper;
import io.github.livenne.annotation.orm.*;
import io.github.livenne.common.model.dto.user.UserFavoriteSaveDTO;
import io.github.livenne.common.model.entity.UserFavorite;

import java.util.List;

@Repository
public interface UserFavoriteRepository extends BaseMapper<UserFavorite> {

    @Query
    UserFavorite getFavorite(@Cond("userId") Long userId, @Cond("goodsId") Long goodsId);

    @Query
    List<UserFavorite> getFavorites(@Cond("userId") Long userId);

    @Insert
    Long favorite(UserFavoriteSaveDTO userFavoriteSaveDTO);

    @Delete
    void unFavorite(UserFavoriteSaveDTO userFavoriteSaveDTO);

}
