package com.stufacesigninsystem.demo.Controller;

import com.stufacesigninsystem.demo.Service.TokenService;
import net.minidev.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginContorllerr {
    @Autowired
    private StudentMapper sqlmp;

    @PostMapping("/login")
    Object login (HttpServletRequest req){
        JSONObject json = new JSONObject();
        String stuid = req.getParameter("stuid");
        String password = req.getParameter("password");
        int stuidresult =sqlmp.findstuid(stuid);

        if (stuidresult == 0){
            json.put("code",-1);
            json.put("msg","not have this stuid");
            return json;
        }else{
            int passwordresult =sqlmp.findpassword(password,stuid);
            if(passwordresult == 0) {
                json.put("code", -1);
                json.put("msg", "password error");
                return json;
            }else{
                if(stuidresult == 1 && passwordresult == 1){
                    String token;
                    TokenService tokenService = new TokenService();
                    token = tokenService.createToken(stuid, password);
                    json.put("code",1);
                    json.put("msg","login success");
                    json.put("token", token);
                    json.put("stuid",stuid);
                    return json;
                }
            }
        }
        json.put("msg","login failed");
        return json;
    }
}
