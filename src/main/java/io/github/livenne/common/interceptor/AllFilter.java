package io.github.livenne.common.interceptor;

import io.github.livenne.ResponseEntity;
import io.github.livenne.annotation.context.Autowired;
import io.github.livenne.annotation.servlet.Interceptor;
import io.github.livenne.common.model.entity.User;
import io.github.livenne.service.UserService;
import io.github.livenne.utils.JwtUtils;
import io.github.livenne.utils.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@Interceptor
public class AllFilter implements Filter {

    @Autowired
    private UserService userService;

    Set<String> authList = Set.of("/shop","/user");
    Set<String> adminList = Set.of("/admin");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        boolean inAuthList = authList.stream().anyMatch(url::startsWith);
        boolean inAdminList = adminList.stream().anyMatch(url::startsWith);

        if (!inAuthList){
            chain.doFilter(request,response);
            return;
        }

        String token = req.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")){
            PrintWriter writer = res.getWriter();
            writer.println(StringUtils.toJson(ResponseEntity.unAuth()));
            return;
        }
        token = token.substring("Bearer ".length());
        if (!JwtUtils.validateToken(token)) {
            PrintWriter writer = res.getWriter();
            writer.println(StringUtils.toJson(ResponseEntity.unAuth()));
            return;
        }
        User user = userService.getById(Long.parseLong(JwtUtils.getDecoded(token).getIssuer()));
        req.setAttribute("userId", user.getId());
        req.setAttribute("level", user.getLevel());

        if (inAdminList && user.getLevel() < 999){
            PrintWriter writer = res.getWriter();
            writer.println(StringUtils.toJson(ResponseEntity.notPermission()));
            return;
        }

        chain.doFilter(request,response);
    }
}
