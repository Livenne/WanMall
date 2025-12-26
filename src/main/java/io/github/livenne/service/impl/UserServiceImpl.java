package io.github.livenne.service.impl;

import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.context.Service;
import io.github.livenne.common.model.dto.user.*;
import io.github.livenne.common.model.entity.*;
import io.github.livenne.repository.*;
import io.github.livenne.service.GoodsService;
import io.github.livenne.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCartRepository userCartRepository;
    @Autowired
    private UserFavoriteRepository userFavoriteRepository;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserAddrRepository userAddrRepository;
    @Autowired
    private GoodsCommentRepository goodsCommentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long save(UserSaveDTO userSaveDTO) {
        return userRepository.save(userSaveDTO);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public void addAddr(Long id, UserAddrDTO userAddrDTO) {
        String addr = String.format("%s,%s,%s", userAddrDTO.getAddr(), userAddrDTO.getName(), userAddrDTO.getPhoneNumber());
        UserAddrSaveDTO userAddrSaveDTO = new UserAddrSaveDTO(id, addr);
        userAddrRepository.addAddr(userAddrSaveDTO);
    }

    @Override
    public void removeAddr(Long userId, Long addrId) {
        userAddrRepository.deleteAddr(addrId, userId);
    }

    @Override
    public void updateScore(Long id, Long score) {
        userRepository.updateScore(id,score);
    }

    @Override
    public void updateNickname(Long id, String nickname) {
        userRepository.updateNickname(id,nickname);
    }

    @Override
    public void updatePassword(Long id, String password) {
        userRepository.updatePassword(id,password);
    }

    @Override
    public void updateAvatar(Long id, String url) {
        userRepository.updateAvatar(id,url);
    }

    @Override
    public void updateDefAddr(Long userId, Long addrId) {
        userRepository.updateDefAddr(userId, addrId);
    }

    @Override
    public void updateAddr(Long userId, Long addrId, UserAddrDTO userAddrDTO) {
        String addr = String.format("%s,%s,%s", userAddrDTO.getAddr(), userAddrDTO.getName(), userAddrDTO.getPhoneNumber());
        userAddrRepository.updateAddr(addrId, userId, addr);
    }

    @Override
    public List<UserCart> getCarts(Long id) {
        return userCartRepository.getCarts(id);
    }

    @Override
    public boolean favorite(Long userId, Long goodsId) {
        if (!isFavorite(userId,goodsId)) {
            userFavoriteRepository.favorite(new UserFavoriteSaveDTO(userId, goodsId));
            return true;
        }
        userFavoriteRepository.unFavorite(new UserFavoriteSaveDTO(userId,goodsId));
        return false;
    }

    @Override
    public boolean isFavorite(Long userId, Long goodsId) {
        return userFavoriteRepository.getFavorite(userId, goodsId) != null;
    }

    @Override
    public List<Goods> getFavorites(Long userId) {
        return userFavoriteRepository.getFavorites(userId).stream()
                .map(UserFavorite::getGoodsId)
                .map(goodsService::getById)
                .toList();
    }

    @Override
    public List<UserAddr> getAddrList(Long userId) {
        return userAddrRepository.getUserAddr(userId);
    }

    @Override
    public List<GoodsComment> getComments(Long userId) {
        return goodsCommentRepository.getByUserId(userId);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void update(Long id,UserSaveDTO userSaveDTO) {
        userRepository.update(id,userSaveDTO);
    }

    @Override
    public List<Order> getOrders(Long id) {
        return orderRepository.getOrdersByUserId(id);
    }
}
