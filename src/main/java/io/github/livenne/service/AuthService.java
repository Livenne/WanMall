package io.github.livenne.service;

import io.github.livenne.common.model.dto.user.UserLoginDTO;
import io.github.livenne.common.model.dto.user.UserRegisterDTO;
import io.github.livenne.common.model.entity.User;

import java.util.regex.Pattern;

public interface AuthService {

    Pattern USERNAME = Pattern.compile("^[a-zA-Z0-9_]{6,15}$");
    Pattern PASSWORD = Pattern.compile("^[a-zA-Z0-9_]{8,18}$");
    Pattern NICKNAME = Pattern.compile("^[a-zA-Z0-9_\\u4e00-\\u9fa5]{3,12}$");
    Pattern EMAIL = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");


    Boolean isExistsById(Long id);

    Boolean isExistsByUsername(String username);

    Boolean isExistsByEmail(String email);

    User login(UserLoginDTO userLoginDTO);

    User register(UserRegisterDTO userRegisterDTO);
}
