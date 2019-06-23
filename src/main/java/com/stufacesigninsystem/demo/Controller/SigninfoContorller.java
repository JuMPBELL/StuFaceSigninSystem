package com.stufacesigninsystem.demo.Controller;

import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class SigninfoContorller {
    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/signinfo")
    List<Map> signinfo(@RequestParam("stuid") String stuid){
        List<Map> list = studentMapper.findsinginfo(stuid);
        System.out.println(list);
        return list;
    }
}

