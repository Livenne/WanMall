package io.github.livenne.service;

import io.github.livenne.common.model.dto.user.UserAddrDTO;
import io.github.livenne.common.model.dto.user.UserSaveDTO;
import io.github.livenne.common.model.dto.user.UserUpdateDTO;
import io.github.livenne.common.model.entity.*;

import java.util.List;

public interface UserService {
    Long save(UserSaveDTO userSaveDTO);

    User getById(Long id);

    User getByUsername(String username);

    User getByEmail(String email);

    void addAddr(Long id, UserAddrDTO userAddrDTO);

    void removeAddr(Long userId, Long addrId);

    void updateScore(Long id, Long score);

    void updateNickname(Long id, String nickname);

    void updatePassword(Long id, String password);

    void updateAvatar(Long id, String url);

    void updateDefAddr(Long userId, Long addrId);

    void updateAddr(Long userId, Long addrId, UserAddrDTO userAddrDTO);


    List<UserCart> getCarts(Long id);

    boolean favorite(Long userId, Long goodsId);

    boolean isFavorite(Long userId, Long goodsId);

    List<Goods> getFavorites(Long userId);

    List<UserAddr> getAddrList(Long userId);

    List<GoodsComment> getComments(Long userId);

    List<User> getUserList();

    void delete(Long id);

    void update(Long id,UserSaveDTO userSaveDTO);

    List<Order> getOrders(Long id);
}
