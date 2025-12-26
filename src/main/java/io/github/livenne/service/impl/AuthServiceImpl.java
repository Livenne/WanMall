package io.github.livenne.service.impl;

import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.context.Service;
import io.github.livenne.common.model.dto.user.UserLoginDTO;
import io.github.livenne.common.model.dto.user.UserRegisterDTO;
import io.github.livenne.common.model.dto.user.UserSaveDTO;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.service.AuthService;
import io.github.livenne.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public Boolean isExistsById(Long id) {
        return userService.getById(id) != null;
    }

    @Override
    public Boolean isExistsByUsername(String username) {
        return userService.getByUsername(username) != null;
    }

    @Override
    public Boolean isExistsByEmail(String email) {
        return userService.getByEmail(email) != null;
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User user = userService.getByUsername(userLoginDTO.getUsername());
        if (user == null){
            return null;
        }
        if (!user.getPassword().equals(userLoginDTO.getPassword())){
            return null;
        }
        return user;
    }

    @Override
    public User register(UserRegisterDTO userRegisterDTO) {

        UserSaveDTO userSaveDTO = new UserSaveDTO(
                0L,
                0L,
                userRegisterDTO.getEmail(),
                null,
                userRegisterDTO.getUsername(),
                userRegisterDTO.getNickname(),
                userRegisterDTO.getPassword()
        );

        Long userId = userService.save(userSaveDTO);

        return userService.getById(userId);
    }

}
