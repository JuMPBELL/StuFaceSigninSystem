package com.stufacesigninsystem.demo.Interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import com.stufacesigninsystem.demo.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    TokenService tokenService = new TokenService();
                    DecodedJWT jwt =  tokenService.parseJWT(cookie.getValue());
                    String stuid = jwt.getClaim("stuid").asString();
                    String password = jwt.getClaim("password").asString();
                    int i = studentMapper.findstu(stuid,password);
                    if (i != 1){
                        System.out.println("非法用户");
                        response.sendRedirect("/login");
                        return false;
                    }
                    else {
                        response.setHeader("stuid",stuid);
                        System.out.println("正常用户");
                    }
                }
            }
        }
        else {
            System.out.println("非法进入");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
