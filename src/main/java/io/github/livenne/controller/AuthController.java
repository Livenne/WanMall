package io.github.livenne.controller;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.Controller;
import io.github.livenne.annotation.servlet.PostMapping;
import io.github.livenne.annotation.servlet.RequestBody;
import io.github.livenne.common.model.dto.user.UserForgotPasswordDTO;
import io.github.livenne.common.model.dto.user.UserLoginDTO;
import io.github.livenne.common.model.dto.user.UserRegisterDTO;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.service.AuthService;
import io.github.livenne.utils.JwtUtils;

import java.util.Map;

@Controller("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO userLoginDTO) {
        if (!authService.isExistsByUsername(userLoginDTO.getUsername())){
            return ResponseEntity.err().message("用户名或密码错误");
        }
        User user = authService.login(userLoginDTO);
        if (user == null) {
            return ResponseEntity.err().message("用户名或密码错误");
        }
        return ResponseEntity.ok(Map.of("token", JwtUtils.getToken(user.getId())));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRegisterDTO userRegisterDTO) {
        String email = userRegisterDTO.getEmail();
        String username = userRegisterDTO.getUsername();
        String nickname = userRegisterDTO.getNickname();
        String password = userRegisterDTO.getPassword();
        String confirmPassword = userRegisterDTO.getConfirmPassword();
        if (!AuthService.EMAIL.matcher(email).matches()) {
            return ResponseEntity.err().message("邮箱格式不正确");
        }
        if (!AuthService.USERNAME.matcher(username).matches()) {
            return ResponseEntity.err().message("用户名格式不正确，仅允许数字、英文、下划线且长度在6-15以内");
        }
        if (!AuthService.NICKNAME.matcher(nickname).matches()) {
            return ResponseEntity.err().message("昵称格式不正确，仅允许中文、数字、英文、下划线且长度在3-12以内");
        }
        if (!AuthService.PASSWORD.matcher(password).matches()) {
            return ResponseEntity.err().message("密码格式不正确，仅允许数字、英文、下划线且长度在8-18以内");
        }
        if (!password.equals(confirmPassword)) {
            return ResponseEntity.err().message("确认密码与密码不相同");
        }
        if (authService.isExistsByUsername(username)) {
            return ResponseEntity.err().message("该用户名已存在");
        }
        if (authService.isExistsByEmail(email)) {
            return ResponseEntity.err().message("该邮箱已经注册过一个账号了");
        }
        User user = authService.register(userRegisterDTO);
        return ResponseEntity.ok(Map.of("token", JwtUtils.getToken(user.getId())));
    }

    @PostMapping("/forgotpassword")
    public ResponseEntity forgotPassword(@RequestBody UserForgotPasswordDTO userForgotPasswordDTO) {
        //TODO
        return ResponseEntity.ok();
    }
}
