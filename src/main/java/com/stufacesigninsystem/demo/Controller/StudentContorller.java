package com.stufacesigninsystem.demo.Controller;

import com.stufacesigninsystem.demo.Entity.Student;
import com.stufacesigninsystem.demo.Mapper.StudentMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentContorller {
    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/student")
    Object student(HttpServletRequest req){
        String stuid = req.getParameter("stuid");
        JSONObject json = new JSONObject();
        Map m = studentMapper.findallBystuid(stuid);
        json.put("stuid",m.get("Stu_ID"));
        json.put("stuname",m.get("Stu_Name"));
        json.put("stusex",m.get("Stu_Sex"));
        json.put("stuface",m.get("Stu_Face"));
        return json;
    }
}
